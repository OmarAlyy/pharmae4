package com.ekadsoft.pharmae4.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.Model.RadioTestModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.View.Fragments.SelectRadioFragmentDialog
import kotlinx.android.synthetic.main.select_dialog_fragment.view.*
import java.util.*

class RadioCompanyAdapter(
    var fragmentDialog: SelectRadioFragmentDialog,
    list: List<RadioTestModel>
) : RecyclerView.Adapter<RadioCompanyAdapter.MyViewHolder>() {
    @JvmField
    var list: List<RadioTestModel> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_choose_radio, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.setIsRecyclable(false)
        val dataBean = list[position]
        holder.name!!.text = dataBean.name
        if (dataBean.check) holder.radio!!.isChecked = true else holder.radio!!.isChecked = false
        holder.radio!!.setOnCheckedChangeListener { compoundButton: CompoundButton?, b: Boolean ->
            if (b) {
                fragmentDialog.id = dataBean.id + ""
                fragmentDialog.name = dataBean.name + ""
                if (!fragmentDialog.vieww.list.isComputingLayout) {
                    updatelist()
                    list[position].check = true
                    notifyDataSetChanged()
                }
            }
        }
    }

    private fun updatelist() {
        for (i in list.indices) list[i].check = false
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun initView() {}
    inner class MyViewHolder(view: View?) :
        RecyclerView.ViewHolder(view!!) {
        var radio: RadioButton? = null
        var name: TextView? = null
        private fun initView(itemView: View) {
            radio = itemView.findViewById(R.id.radio)
            name = itemView.findViewById(R.id.name)
        }

        init {
            initView(itemView)
        }
    }

    init {
        this.list = list
    }
}