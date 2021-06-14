package com.thetimickrus.beappsdemoapp.ui.main.genrecontentrecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import com.thetimickrus.beappsdemoapp.ui.services.ContentItemCallback

class GenreContentRecyclerViewAdapter(
    private val onItemClicked: (ContentItem) -> Unit
) : ListAdapter<ContentItem, GenreContentRecyclerViewHolder>(ContentItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreContentRecyclerViewHolder {
        return GenreContentRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.genre_recyclerview_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreContentRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onItemClicked(getItem(position)) }
    }

}