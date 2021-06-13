package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Pivot(
    val contentId: Int? = null,
    val languageId: Int? = null
)
