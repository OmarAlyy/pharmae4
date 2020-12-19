package com.ekadsoft.pharmae4.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ekadsoft.pharmae4.AddClientViewModel
import com.ekadsoft.pharmae4.Model.RadioTestModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.View.Adapters.RadioSelectAdapter
import com.ekadsoft.pharmae4.View.Adapters.SelectCheckBoxAdapter
import kotlinx.android.synthetic.main.select_dialog_fragment.view.*
import java.util.*

class SelectCheckBoxFragmentDialog(
    var title: String,
    var addClientViewModel: AddClientViewModel,
    var typeSelect: Int
) : DialogFragment() {
    var name = ""
    var id = ""
    var page = 1
    var last_page = 1
    private var isLoad = false
    var adapter: RadioSelectAdapter? = null
    lateinit var vieww: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vieww = inflater.inflate(R.layout.select_dialog_fragment, container, false)
        getDialog()!!.getWindow()!!.requestFeature(Window.FEATURE_NO_TITLE);
        initView()

        return vieww


    }

    private fun initView() {
        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        vieww.list.setLayoutManager(layoutManager)
        vieww.text.setText(title)
        page = 1
        data
        vieww.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int
            ) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount: Int = vieww.list.getLayoutManager()!!.getItemCount()
                val visibleItemCount =
                    (vieww.list.getLayoutManager() as LinearLayoutManager).findLastVisibleItemPosition()
                val firstVisibleItemPosition =
                    (vieww.list.getLayoutManager() as LinearLayoutManager).findFirstVisibleItemPosition()
                if (page < last_page
                    && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= 10 && !isLoad
                ) {
                    // ("onScrolled", "onScrolled");
                    page++
                    isLoad = true
                }
            }
        })
        vieww.ok.setOnClickListener(View.OnClickListener {
            if (id != "") {






                dismiss()

            } else Toast.makeText(
                context,
                getString(R.string.required_please_check),
                Toast.LENGTH_SHORT
            ).show()
        })
        vieww.cancel.setOnClickListener(View.OnClickListener { dismiss() })
    }

    private val data: Unit
        private get() {
            val list: MutableList<RadioTestModel> =
                ArrayList()
            for (i in 0..4) {
                list.add(RadioTestModel(i.toString() + "", "test title", false))
            }
            vieww.list.adapter =  SelectCheckBoxAdapter(addClientViewModel.activity, list)
        }
}