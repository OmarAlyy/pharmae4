package com.ekadsoft.pharmae4

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Model.ClinicsModel
import com.ekadsoft.pharmae4.View.Activities.ScheduleDetailsActivity
import java.util.*

class ScheduleDetailsViewModel : ViewModel() {


    lateinit var activity: ScheduleDetailsActivity
    var type = ObservableInt()


    init {
        type = ObservableInt(1)
    }


    fun getData() {

        val list: MutableList<ClinicsModel> =
            ArrayList<ClinicsModel>()


        for (i in 1..3) {
            list.add(ClinicsModel())

        }

    }


}