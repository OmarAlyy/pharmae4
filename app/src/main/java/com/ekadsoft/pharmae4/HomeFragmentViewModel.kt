package com.ekadsoft.pharmae4

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Utilities.GlobalVariables
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.ScheduleActivity
import com.ekadsoft.pharmae4.View.Fragments.HomeFragment

class HomeFragmentViewModel : ViewModel() {


    var fragment: HomeFragment? = null


    fun openClinics() {

        val bundle = Bundle()
        bundle.putInt("type", GlobalVariables.TYPE_CLINICS)
        IntentClass.goToActivity(
            fragment?.activity,
            ScheduleActivity::class.java,
            bundle
        )

    }

    fun openPharmacies() {


        val bundle = Bundle()
        bundle.putInt("type", GlobalVariables.TYPE_PHARMACIES)
        IntentClass.goToActivity(
            fragment?.activity,
            ScheduleActivity::class.java,
            bundle
        )

    }

    fun openVideoCall() {

        val bundle = Bundle()
        bundle.putInt("type", GlobalVariables.TYPE_VIDEO)
        IntentClass.goToActivity(
            fragment?.activity,
            ScheduleActivity::class.java,
            bundle
        )

    }


}