package com.thetimickrus.beappsdemoapp.api.models.content


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ContentItem(
    @SerialName("id")
    val id: Int?, // 50
    @SerialName("title")
    val title: String?, // Accomplices
    @SerialName("cover")
    val cover: Cover?,
    @SerialName("genre_id")
    val genreId: Int?, // 3
    @SerialName("years_production")
    val yearsProduction: String?, // 2016
    @SerialName("count_episodes")
    val countEpisodes: Int?, // 1
    @SerialName("format")
    val format: String?, // 2D HD
    @SerialName("duration")
    val duration: String?, // 90 min
    @SerialName("created_at")
    val createdAt: String?, // 2020-07-23 14:59:29
    @SerialName("updated_at")
    val updatedAt: String?, // 2021-02-12 12:27:51
    @SerialName("cover_recommended")
    val coverRecommended: CoverRecommended?, // null
    @SerialName("languages")
    val languages: List<Language>?,
    @SerialName("genre")
    val genre: Genre?
) : Parcelable