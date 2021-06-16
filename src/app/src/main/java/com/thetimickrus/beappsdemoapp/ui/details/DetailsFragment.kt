package com.thetimickrus.beappsdemoapp.ui.details

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem

class DetailsFragment : Fragment(R.layout.details_fragment) {

    companion object {
        const val CONTENT = "Content"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем фильм...
        val film = arguments?.getParcelable<ContentItem>(CONTENT) as ContentItem

        val coverImageView = view.findViewById<ImageView>(R.id.details_fragment_cover_imageview)
        val titleTextView = view.findViewById<TextView>(R.id.details_title_textview)
        val creationAtTextView = view.findViewById<TextView>(R.id.details_creation_textview)
        val langTextView = view.findViewById<TextView>(R.id.details_lang_textview)

        Glide
            .with(requireActivity())
            .asBitmap()
            .centerCrop()
            .load(Api.instance.getImageUrlById(film.cover?.id.toString()))
            .into(coverImageView)

        titleTextView.text = film.title

        creationAtTextView.text = film.createdAt

        langTextView.text =
            film.languages?.joinToString { languagesItem -> languagesItem.title!! }
    }

}