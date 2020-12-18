package com.ekadsoft.pharmae4.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.SharedPreferences.LoginSession
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.ReportsActivity
import com.ekadsoft.pharmae4.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {

    lateinit var binding: FragmentMoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_more, container, false)

        onClick()

        return binding.root
    }


    fun onClick() {
        binding.cardLanguage.setOnClickListener {
            changeLanguage()
        }
        binding.cardLogOut.setOnClickListener {
            activity?.let { it1 -> LoginSession.clearData(it1) }
        }

        binding.cardReports.setOnClickListener {
            activity?.let { it1 -> IntentClass.goToActivity(it1 , ReportsActivity::class.java , null) }
        }
    }

    fun changeLanguage() {
        val editLanguageFragment = EditLanguageFragment()
        editLanguageFragment.show(activity!!.supportFragmentManager, "lang")
    }

}