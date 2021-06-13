package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class MainPage(
    val channels: List<ChannelsItem?>? = null,
    val banner: List<BannerItem?>? = null,
    val content: List<ContentItem?>? = null
)
