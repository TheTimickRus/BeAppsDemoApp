package com.thetimickrus.beappsdemoapp.api.models.content


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Language(
    @SerialName("id")
    val id: Int?, // 1
    @SerialName("title")
    val title: String?, // English
    @SerialName("short")
    val short: String?, // Eng
) : Parcelable