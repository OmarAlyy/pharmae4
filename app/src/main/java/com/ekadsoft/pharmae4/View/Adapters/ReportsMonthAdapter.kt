package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.Model.ReportsTargetsAndDonePlansModel
import com.ekadsoft.pharmae4.R
import kotlinx.android.synthetic.main.item_chart_month.view.*
import java.util.*

class ReportsMonthAdapter(
    var activity: Activity,
    list: List<ReportsTargetsAndDonePlansModel>
    , var max: Int
) :


    RecyclerView.Adapter<ReportsMonthAdapter.MyViewHolder>() {


    var list: List<ReportsTargetsAndDonePlansModel> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_chart_month, parent, false)
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


        fun bind(model: ReportsTargetsAndDonePlansModel) {
            with(itemView) {


                     itemView.viewDone.post(Runnable {
                         var height = itemView.viewDone.measuredHeight
                         Log.e("viewDone", height.toString())


                model.done = 300
                model.target = 400
                var percentageTargetD = (model.target * 100 / max).toDouble()
                percentageTargetD = (percentageTargetD / 100) * height
                Log.e("percentageTargetD", percentageTargetD.toString())


                var percentageDone = (model.done * 100 / max).toDouble()
                percentageDone = (percentageDone / 100) * height
                Log.e("percentageTargetD", percentageDone.toString())

                itemView.month.text = model.month



                val params: ViewGroup.LayoutParams = viewTarget.getLayoutParams()
                params.height = percentageTargetD.toInt()
                viewTarget.requestLayout()

                val params2: ViewGroup.LayoutParams = viewDone.getLayoutParams()
                params2.height = percentageDone.toInt()
                viewDone.requestLayout()
                     })

            }
        }
    }




    init {
        this.list = list
        this.max = 500
    }
}