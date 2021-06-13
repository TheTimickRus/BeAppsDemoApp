package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Episodes(
    val items: List<ItemsItem?>? = null
)
