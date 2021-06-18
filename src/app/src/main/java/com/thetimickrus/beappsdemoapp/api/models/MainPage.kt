package com.thetimickrus.beappsdemoapp.api.models

import android.os.Parcelable
import com.thetimickrus.beappsdemoapp.api.models.banner.Banner
import com.thetimickrus.beappsdemoapp.api.models.content.Content
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MainPage(
    @SerialName("content")
    val content: List<Content>?,
    @SerialName("banner")
    val banner: List<Banner>?
) : Parcelable