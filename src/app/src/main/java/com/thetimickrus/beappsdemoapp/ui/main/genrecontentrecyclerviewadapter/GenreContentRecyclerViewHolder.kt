package com.thetimickrus.beappsdemoapp.ui.main.genrecontentrecyclerviewadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem

class GenreContentRecyclerViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private var coverImageView: ImageView? = null
    private var titleTextView: TextView? = null

    init {
        coverImageView = view.findViewById(R.id.cover_imageview)
        titleTextView = view.findViewById(R.id.title_textview)
    }

    fun bind(content: ContentItem) {
        Glide
            .with(view)
            .asBitmap()
            .centerCrop()
            .load(Api.instance.getImageUrlById(content.cover?.id.toString()))
            .into(coverImageView!!)

        titleTextView?.text = content.title
    }
}