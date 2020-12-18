package com.ekadsoft.pharmae4.View.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_attachment_files.view.*
import java.util.*

class AttachmentFilesAdapter(
    var activity: Activity,
    list: MutableList<String>
) :
    RecyclerView.Adapter<AttachmentFilesAdapter.MyViewHolder>() {


    var list: MutableList<String> = ArrayList()
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_attachment_files, parent, false)
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

                Picasso.get()
                    .load("file://" + model)
                    .into(itemView.image)

                itemView.delete.setOnClickListener {
                    list.remove(model)
                    notifyDataSetChanged()
                }


            }
        }
    }


    init {
        this.list = list
    }
}