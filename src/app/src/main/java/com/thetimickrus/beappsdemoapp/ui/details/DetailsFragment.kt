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

private const val MAIN_PARAM = "main_param"

class DetailsFragment : Fragment() {

    private var mainParam: ContentItem? = null

    companion object {
        fun newInstance(mainParam: ContentItem) = DetailsFragment().apply {
            arguments = bundleOf(MAIN_PARAM to mainParam)
        }
    }

    private val viewModel: DetailsViewModel by viewModel()

    private val coverImageView = view?.findViewById<ImageView>(R.id.details_cover_imageview)
    private val titleTextView = view?.findViewById<TextView>(R.id.details_title_textview)
    private val creationAtTextView = view?.findViewById<TextView>(R.id.details_creation_textview)
    private val langTextView = view?.findViewById<TextView>(R.id.details_lang_textview)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            mainParam = it.get(MAIN_PARAM) as ContentItem?
        }

        Toast.makeText(requireContext(), "1545435", Toast.LENGTH_SHORT).show()

        Glide
            .with(requireActivity())
            .asBitmap()
            .centerCrop()
            .load(Api.instance.getImageUrlById(mainParam?.cover?.id.toString()))
            .into(coverImageView!!)

        titleTextView?.text = mainParam?.title
        creationAtTextView?.text = mainParam?.createdAt
        langTextView?.text = mainParam?.languages.toString()
    }

}