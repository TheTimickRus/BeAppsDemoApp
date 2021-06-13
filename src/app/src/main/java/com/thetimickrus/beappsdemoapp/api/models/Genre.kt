package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val color: String? = null,
    val isPortrait: Boolean? = null,
    val description: String? = null,
    val id: Int? = null,
    val position: Int? = null,
    val title: String? = null
)
