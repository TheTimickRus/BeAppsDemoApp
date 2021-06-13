package com.thetimickrus.beappsdemoapp.ui.main

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.ContentItem
import com.thetimickrus.beappsdemoapp.api.models.MainPage
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
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

    fun onItemClick(fragmentManager: FragmentManager, contentItem: ContentItem) {
        fragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(R.id.container, DetailsFragment.newInstance())
    }
}