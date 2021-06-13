package com.thetimickrus.beappsdemoapp.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.thetimickrus.beappsdemoapp.api.models.MainPage
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

class Api {

    companion object {
        val instance = Api()

        private const val Domain = "https://www.signalmediacorp.com/api/"
        private const val DomainForImg = "https://www.signalmediacorp.com//b/c/"
    }

    private val client = OkHttpClient.Builder()
        .build()

    private val contentType = "application/json".toMediaType()

    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(Domain)
        .client(client)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    private val service: ApiService = retrofitBuilder.create()

    //=====================================================================

    // Получаем главную страницу
    suspend fun getMainPage(): MainPage {
        return service.getMainPage()
    }

    // Получаем ссылку на изображение
    fun getImageUrlById(id: String): String {
        return "$DomainForImg$id.jpg"
    }

}