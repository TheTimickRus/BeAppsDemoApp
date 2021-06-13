package com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.models.ContentItem
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
import com.thetimickrus.beappsdemoapp.ui.details.DetailsViewModel
import com.thetimickrus.beappsdemoapp.ui.main.genrecontentrecyclerviewadapter.GenreContentRecyclerViewAdapter
import org.koin.java.KoinJavaComponent.getKoin

class MainRecyclerViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private var genreTitleTextView: TextView? = null
    private var genreContentRecyclerView: RecyclerView? = null

    init {
        genreTitleTextView = view.findViewById(R.id.genre_title_textview)
        genreContentRecyclerView = view.findViewById(R.id.genre_content_recyclerview)
    }

    fun bind(fragmentManager: FragmentManager, content: ContentItem) {
        genreTitleTextView?.text = content.title

        val adapter = GenreContentRecyclerViewAdapter(view.context, click = { film ->
            run {
                fragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.container, DetailsFragment.newInstance(film))
                    .commit()
            }
        })

        adapter.submitList(content.content)
        genreContentRecyclerView?.adapter = adapter
    }
}