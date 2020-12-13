package com.ekadsoft.pharmae4

import android.view.Gravity
import androidx.databinding.ObservableInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.transition.Slide
import com.ekadsoft.pharmae4.View.Activities.MainActivity
import com.ekadsoft.pharmae4.View.Fragments.BlogFragment
import com.ekadsoft.pharmae4.View.Fragments.ClientsFragment
import com.ekadsoft.pharmae4.View.Fragments.HomeFragment
import com.ekadsoft.pharmae4.View.Fragments.MoreFragment

class MainViewModel : ViewModel() {


    var activity: MainActivity? = null
    var itemSelector = ObservableInt()


    init {
        itemSelector = ObservableInt(1)
    }


    fun showFragment(type: Int) {

        itemSelector.set(type)

        var fragment: Fragment? = null
        when (type) {
            1 -> {
                fragment = HomeFragment()
                fragment.enterTransition = Slide(Gravity.START)
            }
            2 -> {
                fragment = ClientsFragment()
                fragment.enterTransition = Slide(Gravity.BOTTOM)
            }
            3 -> {
                fragment = BlogFragment()
                fragment.enterTransition = Slide(Gravity.END)
            }
            4 -> {
                fragment = MoreFragment()
                fragment.enterTransition = Slide(Gravity.TOP)
            }

        }
        val fragmentManager = activity!!.supportFragmentManager
        val transaction =
            fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        transaction.commit()
    }


}