package com.thetimickrus.beappsdemoapp.api.models.content


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Content(
    @SerialName("id")
    val id: Int?, // 3
    @SerialName("title")
    val title: String?, // Drama
    @SerialName("color")
    val color: String?, // rgba(34,132,255,.24)
    @SerialName("description")
    val description: String?, // null
    @SerialName("is_portrait")
    val isPortrait: Boolean?, // false
    @SerialName("position")
    val position: Int?, // 0
    @SerialName("content")
    val content: List<ContentItem>?
) : Parcelable