package com.thetimickrus.beappsdemoapp.api.models.banner


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BannerMobileImage(
    @SerialName("original_ext")
    val originalExt: String?, // jpg
    @SerialName("real_type")
    val realType: String?, // i
    @SerialName("host")
    val host: String?, // signalmediacorp.com
    @SerialName("ready_full")
    val readyFull: Int?, // 1
    @SerialName("duration")
    val duration: Int?, // 0
    @SerialName("error")
    val error: Int?, // 0
    @SerialName("ready")
    val ready: Int?, // 1
    @SerialName("id")
    val id: String?, // 828
    @SerialName("width")
    val width: Int?, // 1024
    @SerialName("status")
    val status: Int?, // 200
    @SerialName("height")
    val height: Int? // 1251
) : Parcelable