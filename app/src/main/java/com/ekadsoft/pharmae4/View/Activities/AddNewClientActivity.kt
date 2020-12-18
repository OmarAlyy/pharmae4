package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.AddClientViewModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.databinding.ActivityAddNewClientBinding

class AddNewClientActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNewClientBinding
    lateinit var viewmodel: AddClientViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_client)
        viewmodel = ViewModelProviders.of(this).get(AddClientViewModel::class.java)

        viewmodel!!.activity = this
        binding?.viewmodel = viewmodel
        binding!!.back.setOnClickListener {
            finish()

        }

    }
}