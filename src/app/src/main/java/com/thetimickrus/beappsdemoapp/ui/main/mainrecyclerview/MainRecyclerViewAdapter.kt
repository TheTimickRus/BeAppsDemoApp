package com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.models.content.Content
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import com.thetimickrus.beappsdemoapp.ui.services.ContentCallback

class MainRecyclerViewAdapter(
    private val onItemClicked: (ContentItem) -> Unit
) : ListAdapter<Content, MainRecyclerViewHolder>(ContentCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return MainRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.main_recyclerview_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClicked)
    }

}