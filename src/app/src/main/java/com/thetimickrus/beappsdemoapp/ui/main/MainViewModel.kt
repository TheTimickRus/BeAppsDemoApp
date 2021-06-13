package com.thetimickrus.beappsdemoapp.ui.main

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.MainPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var mainPage: MutableLiveData<MainPage> = MutableLiveData()

    init {
        updateMainPage()
    }

    @JvmName("getMainPageJvm")
    fun getMainPage() = mainPage

    fun updateMainPage() {
        CoroutineScope(Dispatchers.IO).launch {
            val mp = Api.instance.getMainPage()

            Handler(Looper.getMainLooper()).post {
                mainPage.value = mp
            }
        }
    }
}