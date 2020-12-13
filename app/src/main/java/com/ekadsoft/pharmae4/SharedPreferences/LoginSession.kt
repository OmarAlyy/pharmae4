package com.ekadsoft.pharmae4.SharedPreferences

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.ekadsoft.pharmae4.Model.UserDataModel
import com.ekadsoft.pharmae4.Utilities.GlobalVariables
import com.ekadsoft.pharmae4.View.Activities.SplashActivity
import com.google.gson.Gson

object LoginSession {
    private const val USER_DATA_KEY = "userData"
    private const val IS_LOGIN_KEY = "isLogin"
    private const val ACCESS_TOKEN_KEY = "accessTokenKey"
    private const val MOBILE = "MOBILE"
    private const val COUNTRY_AND_CITY = "countryAndCitySaved"
    private const val USER_TYPE_KEY = "userType"
    private const val INTRO = "INTRO"
    private const val EXPIRE_KEY = "expireKey"
    private var loginFile: SharedPreferences? = null

    private fun initLoginSharedPreference(context: Context) {
        loginFile =
            context.getSharedPreferences("loginFile", Context.MODE_PRIVATE)
    }

    fun setUserData(
        activity: Activity,
        user: UserDataModel?,
        accessToken: String?,
        expireKey: String?
    ) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        val gson = Gson()
        val json: String = gson.toJson(user)
        editor.putString(USER_DATA_KEY, json)
        editor.putString(ACCESS_TOKEN_KEY, accessToken)
        editor.putString(EXPIRE_KEY, expireKey)
        editor.putBoolean(IS_LOGIN_KEY, true)
        editor.apply()
    }

    fun setUserData(activity: Activity, user: UserDataModel?) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        val gson = Gson()
        val json: String = gson.toJson(user)
        editor.putString(USER_DATA_KEY, json)
        editor.putBoolean(IS_LOGIN_KEY, true)
        editor.apply()
    }

    fun setShowIntro(activity: Activity, b: Boolean) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        editor.putBoolean(INTRO, b)
        editor.apply()
    }

    fun isShowIntro(activity: Context): Boolean {
        initLoginSharedPreference(activity)
        return loginFile!!.getBoolean(INTRO, false)
    }

    fun setUserType(activity: Activity, userType: Int) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        editor.putInt(USER_TYPE_KEY, userType)
        editor.apply()
    }

    fun getUserType(activity: Context): Int {
        initLoginSharedPreference(activity)
        return loginFile!!.getInt(
            USER_TYPE_KEY,
            GlobalVariables.DEFAULT_USER_TYPE
        )
    }

    fun getUserData(activity: Context): UserDataModel {
        initLoginSharedPreference(activity)
        val gson = Gson()
        val json = loginFile!!.getString(USER_DATA_KEY, "")
        //("json"  , json) ;
        val userDataModel: UserDataModel = gson.fromJson(json, UserDataModel::class.java)
        return if (userDataModel != null) userDataModel else UserDataModel()
    }

    fun isLoggedIn(activity: Activity): Boolean {
        initLoginSharedPreference(activity)
        return loginFile!!.getBoolean(IS_LOGIN_KEY, false)
    }

    fun isLoggedIn(activity: Context): Boolean {
        initLoginSharedPreference(activity)
        return loginFile!!.getBoolean(IS_LOGIN_KEY, false)
    }

    fun setTokenData(
        activity: Context,
        accessToken: String?,
        expireKey: String?
    ) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        editor.putString(ACCESS_TOKEN_KEY, accessToken)
        editor.putString(EXPIRE_KEY, expireKey)
        editor.apply()
    }

    fun setMobile(activity: Context, mobile: String?) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        editor.putString(MOBILE, mobile)
        editor.apply()
    }

    fun getAccessToken(activity: Context): String? {
        initLoginSharedPreference(activity)
        return loginFile!!.getString(ACCESS_TOKEN_KEY, "")
    }

    fun getMobile(activity: Context): String? {
        initLoginSharedPreference(activity)
        return loginFile!!.getString(MOBILE, "")
    }

    fun getExpire(activity: Activity): Long {
        initLoginSharedPreference(activity)
        return java.lang.Long.valueOf(
            loginFile!!.getString(
                EXPIRE_KEY,
                "1"
            )!!
        )
    }

    fun clearData(activity: Context) {
        initLoginSharedPreference(activity)
        val editor = loginFile!!.edit()
        editor.clear()
        editor.apply()
        val intent = Intent(activity, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
    }
}
