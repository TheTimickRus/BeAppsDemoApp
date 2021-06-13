package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val preview: Int? = null,
    val originalExt: String? = null,
    val error: Int? = null,
    val duration: String? = null,
    val readyFull: Int? = null,
    val realType: String? = null,
    val ready: Int? = null,
    val host: String? = null,
    val width: Int? = null,
    val progress: String? = null,
    val id: String? = null,
    val status: Int? = null,
    val height: Int? = null
)
