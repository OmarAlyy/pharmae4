package com.ekadsoft.pharmae4

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Model.ClientsModel
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.AddNewClientActivity
import com.ekadsoft.pharmae4.View.Adapters.ClientListAdapter
import com.ekadsoft.pharmae4.View.Fragments.ClientsFragment
import java.util.*

class ClientsViewModel : ViewModel() {


    lateinit var fragment: ClientsFragment

    var isNoData: ObservableBoolean = ObservableBoolean(false)


    fun addClient() {
        IntentClass.goToActivity(
            fragment.activity,
            AddNewClientActivity::class.java,
            null
        )


    }

    fun getData() {

        val list: MutableList<ClientsModel> =
            ArrayList<ClientsModel>()


        for (i in 1..2) {
            list.add(ClientsModel())

        }

        fragment!!.binding!!.list.adapter = fragment?.let { ClientListAdapter(it.activity!!, list) }
    }


}