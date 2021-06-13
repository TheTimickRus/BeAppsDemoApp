package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ItemsItem(
    val video: Video? = null,
    val title: String? = null,
    val tracks: List<TracksItem?>? = null
)
