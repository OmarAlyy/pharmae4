package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.AddBranchesViewModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.databinding.ActivityAddNewBranchBinding

class AddNewBranchActivity : AppCompatActivity() {





    lateinit var binding: ActivityAddNewBranchBinding
    lateinit var viewmodel: AddBranchesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_branch)
        viewmodel = ViewModelProviders.of(this).get(AddBranchesViewModel::class.java)
        viewmodel!!.activity = this
        binding?.viewmodel = viewmodel


    }


}