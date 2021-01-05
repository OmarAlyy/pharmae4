package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.ScheduleDetailsViewModel
import com.ekadsoft.pharmae4.Utilities.GlobalVariables
import com.ekadsoft.pharmae4.databinding.ActivityScheduleDetailsBinding

class ScheduleDetailsActivity : AppCompatActivity() {

    var type = 0
    lateinit var viewModel: ScheduleDetailsViewModel
    lateinit var binding: ActivityScheduleDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule_details)
        viewModel = ViewModelProviders.of(this).get(ScheduleDetailsViewModel::class.java)
        viewModel.activity = this

        var bundle = intent.getBundleExtra("data")
        type = bundle.getInt("type")
        viewModel.type.set(type)
        binding.viewmodel = viewModel


        binding.back.setOnClickListener { finish() }

        if (type == GlobalVariables.TYPE_CLINICS) {

            binding.iconType.setImageResource(R.drawable.ic_hospital)
            binding.textType.setText(R.string.clinic)

        } else
            if (type == GlobalVariables.TYPE_VIDEO) {

                binding.iconType.setImageResource(R.drawable.ic_phone2)
                binding.textType.setText(R.string.video_call)

            } else
                if (type == GlobalVariables.TYPE_PHARMACIES) {

                    binding.iconType.setImageResource(R.drawable.ic_medicine)
                    binding.textType.setText(R.string.Pharmacies)

                }
    }

}