package com.thetimickrus.beappsdemoapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.ContentItem
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment(R.layout.details_fragment) {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private val viewModel: DetailsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coverImageView = view.findViewById<ImageView>(R.id.details_cover_imageview)
        val titleTextView = view.findViewById<TextView>(R.id.details_title_textview)
        val creationAtTextView = view.findViewById<TextView>(R.id.details_creation_textview)
        val langTextView = view.findViewById<TextView>(R.id.details_lang_textview)

        val film = viewModel.getContent().value

        Glide
            .with(requireActivity())
            .asBitmap()
            .centerCrop()
            .load(Api.instance.getImageUrlById(film?.cover?.id.toString()))
            .into(coverImageView)

        titleTextView.text = film?.title
        creationAtTextView.text = film?.createdAt
        langTextView.text = film?.languages.toString()
    }
}