package com.ekadsoft.pharmae4

import android.app.Activity
import android.graphics.Color
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.ekadsoft.pharmae4.SharedPreferences.ConfigurationFile.getCurrentLanguage
import com.ekadsoft.pharmae4.SharedPreferences.ConfigurationFile.setCurrentLanguage
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.SplashActivity
import com.ekadsoft.pharmae4.View.Fragments.EditLanguageFragment

class EditLanguageViewModel {
    var selectArabic = ObservableBoolean(true)
    var arabicTextColorObservable = ObservableField<Int>()
    var englishTextColorObservable = ObservableField<Int>()
    private var activity: Activity? = null
    private var editLanguageFragment: EditLanguageFragment? = null
    fun init(activity: Activity?, editLanguageFragment: EditLanguageFragment?) {
        this.activity = activity
        this.editLanguageFragment = editLanguageFragment
        selectArabic.set(getCurrentLanguage(activity!!) == "ar")
        setLangTextColor()
    }

    fun selectLang(lang: String) {
        if (getCurrentLanguage(activity!!) == lang) {
            editLanguageFragment!!.dismiss()
        } else {
            setCurrentLanguage(activity!!, lang)
            setLangTextColor()
            IntentClass.goToActivityAndClear(activity, SplashActivity::class.java, null)
        }
    }

    private fun setLangTextColor() {
        if (getCurrentLanguage(activity!!) == "ar") {
            arabicTextColorObservable.set(Color.parseColor("#02aee7"))
            englishTextColorObservable.set(Color.parseColor("#de000000"))
        } else {
            englishTextColorObservable.set(Color.parseColor("#02aee7"))
            arabicTextColorObservable.set(Color.parseColor("#de000000"))
        }
    }
}