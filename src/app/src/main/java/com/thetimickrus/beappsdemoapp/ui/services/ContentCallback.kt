package com.thetimickrus.beappsdemoapp.ui.services

import androidx.recyclerview.widget.DiffUtil
import com.thetimickrus.beappsdemoapp.api.models.content.Content

class ContentCallback : DiffUtil.ItemCallback<Content>() {
    override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
        return oldItem == newItem
    }

}