package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val cover: Cover? = null,
    val duration: String? = null,
    val countEpisodes: Int? = null,
    val updatedAt: String? = null,
    val format: String? = null,
    val createdAt: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val episodes: Episodes? = null,
    val genreId: Int? = null,
    val coverRecommended: CoverRecommended? = null,
    val yearsProduction: String? = null
)
