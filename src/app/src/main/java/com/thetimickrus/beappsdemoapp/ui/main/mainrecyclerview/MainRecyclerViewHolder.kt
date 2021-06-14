package com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.models.content.Content
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import com.thetimickrus.beappsdemoapp.ui.main.genrecontentrecyclerviewadapter.GenreContentRecyclerViewAdapter

class MainRecyclerViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private var genreTitleTextView: TextView? = null
    private var genreContentRecyclerView: RecyclerView? = null

    init {
        genreTitleTextView = view.findViewById(R.id.genre_title_textview)
        genreContentRecyclerView = view.findViewById(R.id.genre_content_recyclerview)
    }

    fun bind(content: Content, onItemClicked: (ContentItem) -> Unit) {
        genreTitleTextView?.text = content.title

        val adapter = GenreContentRecyclerViewAdapter(onItemClicked)
        adapter.submitList(content.content)
        genreContentRecyclerView?.adapter = adapter
    }
}