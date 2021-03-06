package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.Model.RadioTestModel
import com.ekadsoft.pharmae4.R
import java.util.*

class SelectCheckBoxAdapter(
    var activity: Activity,
    list: MutableList<RadioTestModel>
) :
    RecyclerView.Adapter<SelectCheckBoxAdapter.MyViewHolder>() {


    var list: MutableList<RadioTestModel> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_select_checkbox, parent, false)
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


        fun bind(model: RadioTestModel) {
            with(itemView) {



            }
        }
    }


    init {
        this.list = list
    }
}