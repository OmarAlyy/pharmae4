package com.ekadsoft.pharmae4.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.ekadsoft.pharmae4.R
import kotlinx.android.synthetic.main.fragment_filter_dialog.view.*


class FilterDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_filter_dialog, container, false)
        getDialog()!!.getWindow()!!.requestFeature(Window.FEATURE_NO_TITLE);

        view.close.setOnClickListener { dismiss() }
        view.Search.setOnClickListener { dismiss() }
        view.Reset.setOnClickListener { dismiss() }
        return view
    }


}