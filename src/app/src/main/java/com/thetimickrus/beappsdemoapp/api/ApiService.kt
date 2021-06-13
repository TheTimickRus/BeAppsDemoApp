package com.thetimickrus.beappsdemoapp.api

import com.thetimickrus.beappsdemoapp.api.models.MainPage
import retrofit2.http.GET

interface ApiService {
    @GET("main_page")
    suspend fun getMainPage(): MainPage
}