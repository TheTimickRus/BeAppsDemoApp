package com.thetimickrus.beappsdemoapp.ui.error

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.thetimickrus.beappsdemoapp.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ErrorFragment : Fragment() {
    private var eMessage: String? = null
    private var eStackTrace: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            eMessage = it.getString(ARG_PARAM1)
            eStackTrace = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val messageTextView = view.findViewById<TextView>(R.id.error_fragment_message_textview)
        messageTextView?.text = eMessage!!
    }

    companion object {
        @JvmStatic
        fun newInstance(eMsg: String, eTrace: String) =
            ErrorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, eMsg)
                    putString(ARG_PARAM2, eTrace)
                }
            }
    }
}