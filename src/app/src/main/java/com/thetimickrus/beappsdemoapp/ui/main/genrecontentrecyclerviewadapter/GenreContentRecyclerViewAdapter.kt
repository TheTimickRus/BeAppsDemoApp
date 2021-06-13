package com.thetimickrus.beappsdemoapp.ui.main.genrecontentrecyclerviewadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.models.ContentItem
import com.thetimickrus.beappsdemoapp.ui.service.ContentItemCallback

class GenreContentRecyclerViewAdapter(
    context: Context,
    private val click: (film: ContentItem) -> Unit
) :
    ListAdapter<ContentItem, GenreContentRecyclerViewHolder>(ContentItemCallback()) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreContentRecyclerViewHolder {
        return GenreContentRecyclerViewHolder(
            inflater.inflate(
                R.layout.genre_recyclerview_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreContentRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position), click)
    }

}