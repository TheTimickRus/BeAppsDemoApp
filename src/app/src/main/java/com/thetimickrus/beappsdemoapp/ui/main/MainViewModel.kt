package com.thetimickrus.beappsdemoapp.ui.main

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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
                    // Подготавливаем аргументы
                    val bundle = Bundle()
                    bundle.putString(ErrorFragment.E_MSG, e.message)

                    // Переход на страницу ошибки
                    getKoin().getProperty<MainActivity>("MainActivity")
                        ?.navController?.navigate(R.id.action_mainFragment_to_errorFragment, bundle)
                }
            }
        }
    }

    fun onItemClick(contentItem: ContentItem) {
        // Подготавливаем аргументы
        val bundle = Bundle()
        bundle.putParcelable(DetailsFragment.CONTENT, contentItem)

        // Переход на страницу с детальной информацией
        getKoin().getProperty<MainActivity>("MainActivity")
            ?.navController?.navigate(
                R.id.action_mainFragment_to_detailsFragment,
                bundle
            )
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

}