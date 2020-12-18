package com.ekadsoft.pharmae4.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.ekadsoft.pharmae4.EditLanguageViewModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.databinding.FragmentEditLanguageBinding
import java.util.*

class EditLanguageFragment : DialogFragment() {
    var lang = ""
    var locale: Locale? = null
    lateinit var fragmentEditLanguageBinding: FragmentEditLanguageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentEditLanguageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_language, container, false)
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        val editLanguageViewModel = EditLanguageViewModel()
        fragmentEditLanguageBinding.setElvm(editLanguageViewModel)
        editLanguageViewModel.init(activity, this)
        return fragmentEditLanguageBinding.getRoot()
    }
}