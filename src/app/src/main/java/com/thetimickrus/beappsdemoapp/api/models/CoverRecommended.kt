package com.thetimickrus.beappsdemoapp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class CoverRecommended(
	val duration: Int? = null,
	val originalExt: String? = null,
	val readyFull: Int? = null,
	val realType: String? = null,
	val ready: Int? = null,
	val width: Int? = null,
	val host: String? = null,
	val id: String? = null,
	val error: Int? = null,
	val height: Int? = null,
	val status: Int? = null
)
