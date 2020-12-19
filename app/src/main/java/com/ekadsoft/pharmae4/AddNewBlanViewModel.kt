package com.ekadsoft.pharmae4

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Model.TimeModel
import com.ekadsoft.pharmae4.View.Activities.NewPlanActivity
import com.ekadsoft.pharmae4.View.Adapters.TimeSelectAdapter
import java.util.*

class AddNewBlanViewModel : ViewModel() {


    lateinit var activity: NewPlanActivity
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

    fun openBranche() {


    }


    fun getData() {

        val list: MutableList<TimeModel> =
            ArrayList<TimeModel>()


        for (i in 1..10) {

            if (i % 2 == 0)
            list.add(TimeModel("", "09:00 AM", true, false))
            else
                list.add(TimeModel("", "09:00 AM", false, false))



        }

        activity.binding.list.adapter = TimeSelectAdapter(activity , list)
    }


}