package com.thetimickrus.beappsdemoapp.api.models.content


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Cover(
    @SerialName("ready")
    val ready: Int?, // 1
    @SerialName("width")
    val width: Int?, // 1024
    @SerialName("ready_full")
    val readyFull: Int?, // 1
    @SerialName("height")
    val height: Int?, // 608
    @SerialName("real_type")
    val realType: String?, // i
    @SerialName("status")
    val status: Int?, // 200
    @SerialName("duration")
    val duration: Int?, // 0
    @SerialName("error")
    val error: Int?, // 0
    @SerialName("original_ext")
    val originalExt: String?, // jpg
    @SerialName("host")
    val host: String?, // signalmediacorp.com
    @SerialName("id")
    val id: String? // 852
) : Parcelable