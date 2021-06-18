package com.thetimickrus.beappsdemoapp.viewmodels

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thetimickrus.beappsdemoapp.MainActivity
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.MainPage
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
import com.thetimickrus.beappsdemoapp.ui.error.ErrorFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.java.KoinJavaComponent.getKoin

class MainViewModel : ViewModel() {

    init {
        updateMainPage()
    }

    private var mainPage: MutableLiveData<MainPage> = MutableLiveData()
    fun getMainPage() = mainPage
    fun updateMainPage() {
        getMainPageWithRxJavaObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onNext(it)
            }, {
                onError(it)
            }, {
                onComplete()
            })

        /*

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = Api.instance.getMainPage().awaitResponse()
                if (response.isSuccessful) {
                    val mp = response.body()!!

                    withContext(Dispatchers.Main) {
                        mainPage.value = mp
                        showToast("Данные обновлены!")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Подготавливаем аргументы
                    val bundle = Bundle()
                    bundle.putString(ErrorFragment.E_MSG, e.message)

                    // Переход на страницу ошибки
                    getKoin().getProperty<MainActivity>("MainActivity")
                        ?.navController?.navigate(R.id.action_mainFragment_to_errorFragment, bundle)
                }
            }
        }

        */
    }

    //==================================================================================

    /**
     * Нажатие на элемент из GenreContentRecyclerView
     */
    fun onItemClick(contentItem: ContentItem) {
        val bundle = Bundle()
        bundle.putParcelable(DetailsFragment.CONTENT, contentItem)

        getKoin().getProperty<MainActivity>("MainActivity")
            ?.navController?.navigate(
                R.id.action_mainFragment_to_detailsFragment,
                bundle
            )
    }

    //==================================================================================

    /**
     * Действие при успешном выполнении запроса
     */
    private fun onNext(mp: MainPage) {
        mainPage.postValue(mp)
    }

    /**
     * Действие, если произошла ошибка при выполнении запроса
     */
    private fun onError(t: Throwable) {
        showToast("Произошла ошибка!")

        val bundle = Bundle()
        bundle.putString(ErrorFragment.E_MSG, t.message)

        getKoin().getProperty<MainActivity>("MainActivity")
            ?.navController?.navigate(R.id.action_mainFragment_to_errorFragment, bundle)
    }

    /**
     * Действие, если запрос успешно выполнен
     */
    private fun onComplete() {
        showToast("Данные обновлены!")
    }

    //==================================================================================

    /**
     * Используем Observable
     */
    private fun getMainPageWithRxJavaObservable(): Observable<MainPage> {
        return Observable.create {
            it.onNext(onCell())
            it.onComplete()
        }
    }

    /**
     * Используем Flow
     */
    private fun getMainPageWithRxJavaFlow(): Flowable<MainPage> {
        return Flowable.create({
            it.onNext(onCell())
            it.onComplete()
        }, BackpressureStrategy.BUFFER)
    }

    private fun onCell(): MainPage {
        return Api.instance.getMainPage().execute().body()!!
    }

    //================================ [Различные функции] ================================

    /**
     * Показываем Toast-уведомление
     */
    private fun showToast(message: String, length: Int = Toast.LENGTH_LONG) {
        val context = getKoin().getProperty<AppCompatActivity>("MainActivity")
            ?.applicationContext

        Toast.makeText(
            context,
            message,
            length
        ).show()
    }

}