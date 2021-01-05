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


   lateinit var activity: MainActivity
    var itemSelector = ObservableInt()

    init {
        itemSelector = ObservableInt(1)
    }


    fun showFragment(type: Int) {

        itemSelector.set(type)

        var fragment: Fragment? = null
        when (type) {
            1 -> {
                activity.binding.title.text = activity.getString(R.string.home)
                fragment = HomeFragment()
                fragment.enterTransition = Slide(Gravity.START)
            }
            2 -> {
                activity.binding.title.text = activity.getString(R.string.ClientList)

                fragment = ClientsFragment()
                fragment.enterTransition = Slide(Gravity.BOTTOM)
            }
            3 -> {
                activity.binding.title.text = activity.getString(R.string.Blog)

                fragment = BlogFragment()
                fragment.enterTransition = Slide(Gravity.END)
            }
            4 -> {
                activity.binding.title.text = activity.getString(R.string.More)
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