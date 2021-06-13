package com.thetimickrus.beappsdemoapp.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thetimickrus.beappsdemoapp.api.models.ContentItem

class DetailsViewModel : ViewModel() {
    private val content: MutableLiveData<ContentItem> = MutableLiveData()

    @JvmName("getContent1")
    fun getContent() = content

    fun setContent(contentItem: ContentItem) {
        content.value = contentItem
    }
}