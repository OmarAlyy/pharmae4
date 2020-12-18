package com.ekadsoft.pharmae4.View.Activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ekadsoft.pharmae4.Model.ReportsTargetsAndDonePlansModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.View.Adapters.ReportsMonthAdapter
import com.ekadsoft.pharmae4.View.Adapters.ReportsNumbersAdapter
import com.ekadsoft.pharmae4.databinding.ActivityReportsBinding
import java.text.DateFormatSymbols


class ReportsActivity : AppCompatActivity() {

    lateinit var binding: ActivityReportsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reports)


        val min = 400
        val max = 600


        val list: MutableList<ReportsTargetsAndDonePlansModel> =
            ArrayList<ReportsTargetsAndDonePlansModel>()

        val months: Array<String> = DateFormatSymbols().getMonths()


        val numbers: MutableList<String> =
            ArrayList<String>()

        val num = max / 6
        for (i in 6 downTo 1) {
            numbers.add((num * i).toString())

        }
        numbers.add("0")



        for (i in 0..months.size - 1) {
            list.add(
                ReportsTargetsAndDonePlansModel(
                    months.get(i),
                    (Math.random() * (max - min + 1) + min).toInt(),
                    (Math.random() * (max - min + 1) + min).toInt()
                )
            )

        }

        binding!!.listMonths.adapter = ReportsMonthAdapter(this, list, max)
        binding!!.listNumbers.adapter = ReportsNumbersAdapter(this, numbers)

    }


}