package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.LoginViewModel
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

  lateinit  var viewmodel: LoginViewModel

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewmodel.activity = this
         binding.viewmodel = viewmodel
        binding.login
        binding.login!!.performClick()
    }
}