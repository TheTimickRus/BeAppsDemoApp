package com.thetimickrus.beappsdemoapp.ui.details

import android.icu.util.LocaleData
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.api.Api
import com.thetimickrus.beappsdemoapp.api.models.content.ContentItem
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toLocalDate
import kotlinx.datetime.toLocalDateTime
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent.getKoin
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

class DetailsFragment : Fragment(R.layout.details_fragment) {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    // Оставлено, чтобы потом использовать!
    private val viewModel: DetailsViewModel by viewModel()
    // Оставлено, чтобы потом использовать!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coverImageView = view.findViewById<ImageView>(R.id.details_fragment_cover_imageview)
        val titleTextView = view.findViewById<TextView>(R.id.details_title_textview)
        val creationAtTextView = view.findViewById<TextView>(R.id.details_creation_textview)
        val langTextView = view.findViewById<TextView>(R.id.details_lang_textview)

        // ЭТО ПРЯМ ДИЧЬ ДИКАЯ, НО КАК ПО ДРУГОМУ СДЕЛАТЬ - ХЗ
        val film = getKoin().getProperty<ContentItem>("DetailsContent")
        // ЭТО ПРЯМ ДИЧЬ ДИКАЯ, НО КАК ПО ДРУГОМУ СДЕЛАТЬ - ХЗ
        
        Glide
            .with(requireActivity())
            .asBitmap()
            .centerCrop()
            .load(Api.instance.getImageUrlById(film?.cover?.id.toString()))
            .into(coverImageView)

        titleTextView.text = film?.title

        creationAtTextView.text =
            film?.createdAt
                ?.replace(' ', 'T')
                ?.toLocalDateTime()?.toJavaLocalDateTime()
                ?.format(
                    DateTimeFormatter.ofPattern("dd-MM-yy")
                )

        langTextView.text =
            film?.languages?.joinToString { languagesItem -> languagesItem.title!! }
    }
}