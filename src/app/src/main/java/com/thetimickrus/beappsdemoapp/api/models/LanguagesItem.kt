package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class LanguagesItem(
    val jsonMemberShort: String? = null,
    val pivot: Pivot? = null,
    val id: Int? = null,
    val title: String? = null
)
