package com.thetimickrus.beappsdemoapp.api.models.banner


import android.os.Parcelable
import com.thetimickrus.beappsdemoapp.api.models.content.CoverRecommended
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BannerContent(
    @SerialName("id")
    val id: Int?, // 61
    @SerialName("title")
    val title: String?, // The amulet of life
    @SerialName("cover")
    val bannerCover: BannerCover?,
    @SerialName("genre_id")
    val genreId: Int?, // 5
    @SerialName("years_production")
    val yearsProduction: String?, // 2021
    @SerialName("count_episodes")
    val countEpisodes: Int?, // 1
    @SerialName("format")
    val format: String?, // 4K 
    @SerialName("duration")
    val duration: String?, // 90 min
    @SerialName("created_at")
    val createdAt: String?, // 2020-07-24 18:27:02
    @SerialName("updated_at")
    val updatedAt: String?, // 2021-03-12 11:07:39
    @SerialName("cover_recommended")
    val coverRecommended: CoverRecommended?
) : Parcelable