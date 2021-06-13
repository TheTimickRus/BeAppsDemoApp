package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ChannelsItem(
    val cover: Cover? = null,
    val promo: Promo? = null,
    val hours: List<HoursItem?>? = null,
    val viewerProfile: List<ViewerProfileItem?>? = null,
    val updatedAt: String? = null,
    val languages: List<LanguagesItem?>? = null,
    val stream: String? = null,
    val logo: Logo? = null,
    val createdAt: String? = null,
    val id: Int? = null,
    val title: String? = null
)
