package com.thetimickrus.beappsdemoapp.ui.main

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import com.thetimickrus.beappsdemoapp.api.models.MainPage
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.getKoin


class MainViewModel : ViewModel() {
    private var mainPage: MutableLiveData<MainPage> = MutableLiveData()

    init {
        updateMainPage()
    }

    @JvmName("getMainPageJvm")
    fun getMainPage() = mainPage

    fun updateMainPage() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val mp = Api.instance.getMainPage()

                Handler(Looper.getMainLooper()).post {
                    mainPage.value = mp
                }
            }
        } catch (e: Exception) {
            Toast.makeText(
                getKoin().getProperty<AppCompatActivity>("MainActivity"),
                e.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun onItemClick(contentItem: ContentItem) {
        // ЭТО ПРЯМ ДИЧЬ ДИКАЯ, НО КАК ПО ДРУГОМУ СДЕЛАТЬ - ХЗ
        getKoin().setProperty("DetailsContent", contentItem)
        // ЭТО ПРЯМ ДИЧЬ ДИКАЯ, НО КАК ПО ДРУГОМУ СДЕЛАТЬ - ХЗ

        // ЭТО, ЧЕСТНО ГОВОРЯ, ТОЖЕ ТАКОЕ СЕБЕ
        getKoin().getProperty<AppCompatActivity>("MainActivity")?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.main_activity_container, DetailsFragment.newInstance())
            ?.commit()
        // ЭТО, ЧЕСТНО ГОВОРЯ, ТОЖЕ ТАКОЕ СЕБЕ
    }
}