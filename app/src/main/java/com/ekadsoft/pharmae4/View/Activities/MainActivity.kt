package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.MainViewModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var viewmodel: MainViewModel? = null


    var binding: ActivityMainBinding? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewmodel!!.activity = this
        binding?.viewmodel = viewmodel
        viewmodel!!.showFragment(1)

    }

}