package com.ekadsoft.pharmae4.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.ClientsViewModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.databinding.FragmentClientsBinding


class ClientsFragment : Fragment() {


    lateinit var binding: FragmentClientsBinding
    lateinit var viewModel: ClientsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_clients, container, false)

        viewModel = ViewModelProviders.of(this).get(ClientsViewModel::class.java)
        viewModel!!.fragment = this
        binding?.viewmodel = viewModel

        viewModel.getData()
        return binding.root

    }

}