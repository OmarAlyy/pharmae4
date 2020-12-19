package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.Model.ClinicsModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.AddFeedbackActivity
import com.ekadsoft.pharmae4.View.Activities.FeedbackSummaryActivity
import com.ekadsoft.pharmae4.View.Activities.ScheduleDetailsActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ScheduleHistoryAdapter(
    var activity: Activity,
    list: List<ClinicsModel>
) :
    RecyclerView.Adapter<ScheduleHistoryAdapter.MyViewHolder>() {

    var type = 0

    var list: List<ClinicsModel> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule_history, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataBean = list[position]

        if (position < 3 && position != 0)
            type = position

        if (type == 1) {

            holder.Feedback.visibility = View.VISIBLE
            holder.status!!.setTextColor(activity.getColor(R.color.colorPrimary))

            holder.FeedbackSummary.visibility = View.GONE
            holder.status!!.text = "Finished"
            holder.viewColor!!.setBackgroundColor(activity.getColor(R.color.colorPrimary))


        } else if (type == 2) {

            holder.status!!.text = "Cancelled"

            holder.status!!.setTextColor(activity.getColor(R.color.red))

            holder.Feedback.visibility = View.GONE
            holder.FeedbackSummary.visibility = View.GONE
            holder.viewColor!!.setBackgroundColor(activity.getColor(R.color.green))

        } else {
            holder.status!!.setTextColor(activity.getColor(R.color.colorPrimary))
            holder.status!!.text = "Finished"
            holder.Feedback.visibility = View.GONE
            holder.FeedbackSummary.visibility = View.VISIBLE
            holder.viewColor!!.setBackgroundColor(activity.getColor(R.color.foshia))

        }
        holder.card.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("type", type)
            IntentClass.goToActivity(
                activity,
                ScheduleDetailsActivity::class.java,
                bundle
            )

        }
        holder.Feedback.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("type", type)
            IntentClass.goToActivity(
                activity,
                AddFeedbackActivity::class.java,
                bundle
            )

        }

        holder.FeedbackSummary.setOnClickListener {

            IntentClass.goToActivity(
                activity,
                FeedbackSummaryActivity::class.java,
                null
            )

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View?) :
        RecyclerView.ViewHolder(view!!) {
        var image: CircleImageView? = null
        var name: TextView? = null
        var status: TextView? = null
        var time: TextView? = null
        var viewColor: TextView? = null
        var address: TextView? = null
        lateinit var FeedbackSummary: MaterialButton
        lateinit var Feedback: MaterialButton
        lateinit var card: MaterialCardView
        fun initView(itemView: View) {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.name)
            status = itemView.findViewById(R.id.status)
            time = itemView.findViewById(R.id.time)
            viewColor = itemView.findViewById(R.id.viewColor)
            address = itemView.findViewById(R.id.address)
            Feedback = itemView.findViewById(R.id.Feedback)
            FeedbackSummary = itemView.findViewById(R.id.FeedbackSummary)
            card = itemView.findViewById(R.id.card)
        }

        init {
            initView(itemView)
        }
    }

    init {
        this.list = list
    }
}