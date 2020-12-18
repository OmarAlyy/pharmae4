package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.Model.ClientsModel
import com.ekadsoft.pharmae4.R
import kotlinx.android.synthetic.main.item_clients.view.*
import java.util.*

class ClientListAdapter(
    var activity: Activity,
    list: List<ClientsModel>) :
    RecyclerView.Adapter<ClientListAdapter.MyViewHolder>() {


    var list: List<ClientsModel> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_clients, parent, false)
        return MyViewHolder(view)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View?) :
        RecyclerView.ViewHolder(view!!) {


        fun bind(model: ClientsModel) {
            with(itemView) {

                itemView.name.text = "omar aly"

            }
        }
    }


    init {
        this.list = list
    }
}