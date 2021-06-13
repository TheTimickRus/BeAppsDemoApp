package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ContentItem(
    val color: String? = null,
    val isPortrait: Boolean? = null,
    val description: String? = null,
    val id: Int? = null,
    val position: Int? = null,
    val title: String? = null,
    val content: List<ContentItem?>? = null,
    val languages: List<LanguagesItem?>? = null,
    val format: String? = null,
    val createdAt: String? = null,
    val genreId: Int? = null,
    val yearsProduction: String? = null,
    val cover: Cover? = null,
    val duration: String? = null,
    val countEpisodes: Int? = null,
    val updatedAt: String? = null,
    val genre: Genre? = null,
    val episodes: Episodes? = null,
    val coverRecommended: CoverRecommended? = null
)
