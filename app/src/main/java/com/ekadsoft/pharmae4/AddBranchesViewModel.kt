package com.ekadsoft.pharmae4

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.View.Activities.AddNewBranchActivity

class AddBranchesViewModel : ViewModel() {



    lateinit var activity: AddNewBranchActivity
    var type = ObservableInt()

    var typeSelect = 0;

    init {
        type = ObservableInt(1)
    }


    fun back() {

        activity.finish()

    }


    fun save() {

        activity.finish()

    }








}