package com.ekadsoft.pharmae4

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.ScheduleActivity
import com.ekadsoft.pharmae4.View.Fragments.HomeFragment

class HomeFragmentViewModel : ViewModel() {


    var fragment: HomeFragment? = null


    fun openClinics() {

        val bundle = Bundle()
        bundle.putInt("type", 1)
        IntentClass.goToActivity(
            fragment?.activity,
            ScheduleActivity::class.java,
            bundle
        )

    }

    fun openPharmacies() {


        val bundle = Bundle()
        bundle.putInt("type", 2)
        IntentClass.goToActivity(
            fragment?.activity,
            ScheduleActivity::class.java,
            bundle
        )

    }

    fun openVideoCall() {

        val bundle = Bundle()
        bundle.putInt("type", 3)
        IntentClass.goToActivity(
            fragment?.activity,
            ScheduleActivity::class.java,
            bundle
        )

    }


}