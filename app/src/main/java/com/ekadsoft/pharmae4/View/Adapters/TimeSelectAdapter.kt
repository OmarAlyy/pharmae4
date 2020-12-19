package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.Model.TimeModel
import com.ekadsoft.pharmae4.R
import kotlinx.android.synthetic.main.item_time.view.*
import java.util.*

class TimeSelectAdapter(
    var activity: Activity,
    list: List<TimeModel>
) :
    RecyclerView.Adapter<TimeSelectAdapter.MyViewHolder>() {


    var list: List<TimeModel> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_time, parent, false)
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


        fun bind(model: TimeModel) {
            with(itemView) {

                if (model.isCheck) {
                    itemView.time.setTextColor(resources.getColor(R.color.white))
                    itemView.card.setCardBackgroundColor(resources.getColor(R.color.colorPrimary))

                } else if (model.isAvailable) {
                    itemView.time.setTextColor(resources.getColor(R.color.text_black))
                    itemView.card.setCardBackgroundColor(resources.getColor(R.color.white))

                } else if (!model.isAvailable) {
                    itemView.time.setTextColor(resources.getColor(R.color.white))
                    itemView.card.setCardBackgroundColor(resources.getColor(R.color.grayBottom))
                }


                itemView.card.setOnClickListener {

                    if (model.isAvailable) {
                        updatelist()
                        list[position].isCheck = true
                        notifyDataSetChanged()

                    }
                }



                itemView.time.text = model.name


            }
        }
    }


    private fun updatelist() {
        for (i in list.indices) list[i].isCheck = false
    }


    init {
        this.list = list
    }
}