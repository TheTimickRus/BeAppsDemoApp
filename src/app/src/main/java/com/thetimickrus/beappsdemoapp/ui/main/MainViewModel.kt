package com.thetimickrus.beappsdemoapp.ui.main

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.MainPage
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
import com.thetimickrus.beappsdemoapp.ui.error.ErrorFragment
import kotlinx.coroutines.*
import org.koin.java.KoinJavaComponent.getKoin
import retrofit2.awaitResponse


class MainViewModel : ViewModel() {

    init {
        updateMainPage()
    }

    private var mainPage: MutableLiveData<MainPage> = MutableLiveData()
    fun getMainPage() = mainPage
    fun updateMainPage() {
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
                    showToast(e.message!!)

                    // Переходим на страницу ошибки!
                    beginTransaction(
                        ErrorFragment.newInstance(e.message!!, e.stackTraceToString()),
                        false
                    )
                }
            }
        }
    }

    fun onItemClick(contentItem: ContentItem) {
        // ЭТО ПРЯМ ДИЧЬ ДИКАЯ, НО КАК ПО ДРУГОМУ СДЕЛАТЬ - ХЗ
        getKoin().setProperty("DetailsContent", contentItem)
        // ЭТО ПРЯМ ДИЧЬ ДИКАЯ, НО КАК ПО ДРУГОМУ СДЕЛАТЬ - ХЗ

        beginTransaction(DetailsFragment.newInstance())
    }

    private fun showToast(message: String, length: Int = Toast.LENGTH_LONG) {
        val context = getKoin().getProperty<AppCompatActivity>("MainActivity")
            ?.applicationContext

        Toast.makeText(
            context,
            message,
            length
        ).show()
    }

    // ЭТО, ЧЕСТНО ГОВОРЯ, ТОЖЕ ТАКОЕ СЕБЕ
    private fun beginTransaction(
        fragment: Fragment,
        isAddToBackStack: Boolean = true,
        layout: Int = R.id.main_activity_container
    ) {
        val transactionManager =
            getKoin().getProperty<AppCompatActivity>("MainActivity")
                ?.supportFragmentManager
                ?.beginTransaction()

        if (isAddToBackStack) {
            transactionManager?.addToBackStack(null)
        }

        transactionManager
            ?.replace(layout, fragment)
            ?.commit()
    }

}