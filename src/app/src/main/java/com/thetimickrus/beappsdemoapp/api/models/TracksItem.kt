package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class TracksItem(
    val audio: Audio? = null,
    val languageId: Int? = null
)
