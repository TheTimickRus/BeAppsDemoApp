package com.thetimickrus.beappsdemoapp.api.models.banner


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Banner(
    @SerialName("id")
    val id: Int?, // 6
    @SerialName("image")
    val bannerImage: BannerImage?,
    @SerialName("content_id")
    val contentId: Int?, // 61
    @SerialName("channel_id")
    val channelId: Int?, // null
    @SerialName("link")
    val link: String?, // null
    @SerialName("position")
    val position: Int?, // 1
    @SerialName("mobile_image")
    val bannerMobileImage: BannerMobileImage?,
    @SerialName("content")
    val bannerContent: BannerContent?,
) : Parcelable