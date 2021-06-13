package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Audio(
    val originalExt: String? = null,
    val duration: String? = null,
    val readyFull: Int? = null,
    val realType: String? = null,
    val ready: Int? = null,
    val host: String? = null,
    val width: String? = null,
    val progress: String? = null,
    val id: String? = null,
    val error: Int? = null,
    val status: Int? = null,
    val height: String? = null
)
