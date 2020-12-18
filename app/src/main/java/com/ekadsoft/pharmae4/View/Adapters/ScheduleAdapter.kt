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
import com.ekadsoft.pharmae4.View.Activities.ScheduleDetailsActivity
import com.ekadsoft.pharmae4.View.Adapters.ScheduleAdapter.MyViewHolder
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ScheduleAdapter(
    var activity: Activity,
    list: List<ClinicsModel>,
    var type: Int
) :
    RecyclerView.Adapter<MyViewHolder>() {


    var list: List<ClinicsModel> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_clinics, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataBean = list[position]

        if (type == 1)
            holder.viewColor!!.setBackgroundColor(activity.getColor(R.color.colorPrimary))
        else if (type == 2)
            holder.viewColor!!.setBackgroundColor(activity.getColor(R.color.green))
        else
            holder.viewColor!!.setBackgroundColor(activity.getColor(R.color.foshia))

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
        lateinit var Feedback: MaterialButton
        var cancel: MaterialButton? = null
        lateinit var card: MaterialCardView
        fun initView(itemView: View) {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.name)
            status = itemView.findViewById(R.id.status)
            time = itemView.findViewById(R.id.time)
            viewColor = itemView.findViewById(R.id.viewColor)
            address = itemView.findViewById(R.id.address)
            Feedback = itemView.findViewById(R.id.Feedback)
            cancel = itemView.findViewById(R.id.cancel)
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