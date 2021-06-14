package com.thetimickrus.beappsdemoapp.api.models.banner


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BannerCover(
    @SerialName("host")
    val host: String?, // signalmediacorp.com
    @SerialName("status")
    val status: Int?, // 200
    @SerialName("real_type")
    val realType: String?, // i
    @SerialName("width")
    val width: Int?, // 1280
    @SerialName("original_ext")
    val originalExt: String?, // jpg
    @SerialName("ready")
    val ready: Int?, // 1
    @SerialName("height")
    val height: Int?, // 1800
    @SerialName("error")
    val error: Int?, // 0
    @SerialName("duration")
    val duration: Int?, // 0
    @SerialName("id")
    val id: String?, // 267
    @SerialName("ready_full")
    val readyFull: Int? // 1
) : Parcelable