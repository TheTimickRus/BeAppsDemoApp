package com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ListAdapter
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.models.ContentItem
import com.thetimickrus.beappsdemoapp.ui.service.ContentItemCallback

class MainRecyclerViewAdapter(
    private val fragment: Fragment,
    private val onItemClicked: (ContentItem) -> Unit
) : ListAdapter<ContentItem, MainRecyclerViewHolder>(ContentItemCallback()) {

    private val inflater: LayoutInflater = LayoutInflater.from(fragment.context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return MainRecyclerViewHolder(
            inflater.inflate(
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