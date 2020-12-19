package com.ekadsoft.pharmae4

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Model.ClinicsModel
import com.ekadsoft.pharmae4.View.Activities.ScheduleHistoryActivity
import com.ekadsoft.pharmae4.View.Adapters.ScheduleHistoryAdapter
import com.ekadsoft.pharmae4.View.Fragments.FilterDialogFragment
import java.util.*

class ScheduleHistoryViewModel : ViewModel() {


    lateinit var activity: ScheduleHistoryActivity
    var type = ObservableInt()


    init {
        type = ObservableInt(1)
    }

    fun openFilter() {

        FilterDialogFragment().show(activity!!.supportFragmentManager, "")
    }

    fun back() {

        activity.finish()
    }

    fun getData() {

        val list: MutableList<ClinicsModel> =
            ArrayList<ClinicsModel>()


        for (i in 1..5) {
            list.add(ClinicsModel())

        }

        activity!!.binding!!.list.adapter = activity?.let { ScheduleHistoryAdapter(it, list) }
    }


}