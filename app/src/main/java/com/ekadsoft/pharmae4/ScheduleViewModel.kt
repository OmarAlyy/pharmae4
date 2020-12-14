package com.ekadsoft.pharmae4

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Model.ClinicsModel
import com.ekadsoft.pharmae4.View.Activities.ScheduleActivity
import com.ekadsoft.pharmae4.View.Adapters.ScheduleAdapter
import com.ekadsoft.pharmae4.View.Fragments.FilterDialogFragment
import java.util.*

class ScheduleViewModel : ViewModel() {


    var activity: ScheduleActivity? = null
    var type = ObservableInt()


    init {
        type = ObservableInt(1)
    }


    fun openFilter(){

        FilterDialogFragment().show(activity!!.supportFragmentManager,"")
    }

    fun getData() {

        val list: MutableList<ClinicsModel> =
            ArrayList<ClinicsModel>()


        for (i in 1..3) {
            list.add(ClinicsModel())

        }

        activity!!.binding!!.list.adapter = activity?.let { ScheduleAdapter(it, list, type.get()) }
    }


}