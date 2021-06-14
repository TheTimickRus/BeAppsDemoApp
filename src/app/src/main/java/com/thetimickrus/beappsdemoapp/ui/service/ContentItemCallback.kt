package com.thetimickrus.beappsdemoapp.ui.service

import androidx.recyclerview.widget.DiffUtil
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem

class ContentItemCallback : DiffUtil.ItemCallback<ContentItem>() {
    override fun areItemsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
        return oldItem == newItem
    }

}