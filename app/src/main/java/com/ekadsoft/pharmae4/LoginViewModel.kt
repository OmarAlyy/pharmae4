package com.ekadsoft.pharmae4

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Model.UserDataModel
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.LoginActivity
import com.ekadsoft.pharmae4.View.Activities.MainActivity

class LoginViewModel : ViewModel() {


    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var userLogin: MutableLiveData<UserDataModel>? = null

    var activity: LoginActivity? = null

    init {
        btnSelected = ObservableBoolean(false)
        email = ObservableField("")
        password = ObservableField("")
        userLogin = MutableLiveData<UserDataModel>()
    }


    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        email!!.set(s.toString());


    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        password!!.set(s.toString());


    }


    fun forget() {

    }

    fun login() {
        IntentClass.goToActivityAndClear(
            activity,
            MainActivity::class.java,
            null
        )


    }
}