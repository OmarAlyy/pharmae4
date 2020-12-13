package com.ekadsoft.pharmae4.SharedPreferences

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*

object ConfigurationFile {
    private const val LANGUAGE_KEY = "languageKey"
    private const val NOTIFICATIONS_KEY = "notificationsKey"
    private var configFile: SharedPreferences? = null
    fun getCurrentLanguage(context: Context): String? {
        initConfigSharedPreference(context)
        return configFile!!.getString(LANGUAGE_KEY, "ar")
    }

    fun getCurrentLanguageEmpty(context: Context): String? {
        initConfigSharedPreference(context)
        return configFile!!.getString(LANGUAGE_KEY, "")
    }

    fun setCurrentLanguage(context: Context, language: String) {
        var language = language
        initConfigSharedPreference(context)
        if (language == "") language = "ar"
        if (language == "en_US") language = "en_US"
        if (language == "ar") language = "ar"
        try {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            context.resources.updateConfiguration(config, null)
        } catch (a: NullPointerException) {
            a.printStackTrace()
        } catch (a: RuntimeException) {
            a.printStackTrace()
        }
        val editor = configFile!!.edit()
        editor.putString(LANGUAGE_KEY, language)
        editor.apply()
    }

    fun setNotificationStatus(activity: Activity, isActive: Boolean) {
        initConfigSharedPreference(activity)
        val editor = configFile!!.edit()
        editor.putBoolean(NOTIFICATIONS_KEY, isActive)
        editor.apply()
    }

    fun getNotificationStatus(activity: Activity): Boolean {
        initConfigSharedPreference(activity)
        return configFile!!.getBoolean(NOTIFICATIONS_KEY, true)
    }

    fun getNotificationStatus(activity: Context): Boolean {
        initConfigSharedPreference(activity)
        return configFile!!.getBoolean(NOTIFICATIONS_KEY, true)
    }

    private fun initConfigSharedPreference(context: Context) {
        configFile =
            context.getSharedPreferences("configFile", Context.MODE_PRIVATE)
    }
}