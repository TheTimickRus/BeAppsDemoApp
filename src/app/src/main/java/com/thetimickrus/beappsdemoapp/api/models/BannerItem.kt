package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class BannerItem(
    val image: Image? = null,
    val contentId: Int? = null,
    val link: String? = null,
    val channel: String? = null,
    val mobileImage: MobileImage? = null,
    val id: Int? = null,
    val position: Int? = null,
    val channelId: String? = null,
    val content: Content? = null
)
