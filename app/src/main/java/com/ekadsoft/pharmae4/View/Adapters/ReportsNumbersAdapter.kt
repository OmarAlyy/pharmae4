package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.R
import kotlinx.android.synthetic.main.item_chart_number.view.*
import java.util.*

class ReportsNumbersAdapter(
    var activity: Activity,
    list: List<String>
) :
    RecyclerView.Adapter<ReportsNumbersAdapter.MyViewHolder>() {


    var list: List<String> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_chart_number, parent, false)
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


        fun bind(model: String) {
            with(itemView) {

           
                
                itemView.textNum.text = model

            

            }
        }
    }


    init {
        this.list = list
    }
}