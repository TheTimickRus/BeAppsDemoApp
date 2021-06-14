package com.thetimickrus.beappsdemoapp.api

import com.thetimickrus.beappsdemoapp.api.models.MainPage
import retrofit2.Call
import retrofit2.http.GET

interface SignalMediaCorpService {

    @GET("main_page")
    fun getMainPage(): Call<MainPage>

}