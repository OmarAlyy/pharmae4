package com.ekadsoft.pharmae4.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.View.ProgressItem
import com.ekadsoft.pharmae4.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var progressItemList: ArrayList<ProgressItem>? = null
    private var mProgressItem: ProgressItem? = null

    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        return binding.root
    }


    }

