package com.thetimickrus.beappsdemoapp.api.models.banner


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BannerImage(
    @SerialName("ready_full")
    val readyFull: Int?, // 1
    @SerialName("status")
    val status: Int?, // 200
    @SerialName("real_type")
    val realType: String?, // i
    @SerialName("host")
    val host: String?, // signalmediacorp.com
    @SerialName("error")
    val error: Int?, // 0
    @SerialName("width")
    val width: Int?, // 1790
    @SerialName("original_ext")
    val originalExt: String?, // jpg
    @SerialName("ready")
    val ready: Int?, // 1
    @SerialName("id")
    val id: String?, // 951
    @SerialName("height")
    val height: Int?, // 600
    @SerialName("duration")
    val duration: Int? // 0
) : Parcelable