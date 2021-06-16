package com.thetimickrus.beappsdemoapp.ui.error

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.thetimickrus.beappsdemoapp.R

class ErrorFragment : Fragment(R.layout.fragment_error) {

    companion object {
        const val E_MSG = "eMessage"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем ошибку...
        val eMessage = arguments?.getString(E_MSG) ?: "Error!"

        val messageTextView = view.findViewById<TextView>(R.id.error_fragment_message_textview)
        messageTextView?.text = eMessage
    }

}