package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.SharedPreferences.ConfigurationFile
import com.ekadsoft.pharmae4.SharedPreferences.LoginSession
import com.ekadsoft.pharmae4.Utilities.IntentClass
import java.util.*


class SplashActivity : AppCompatActivity() {


    fun generateIncreasingRandoms(amount: Int, max: Int): IntArray? {
        val randomNumbers = IntArray(amount)
        val random = Random()
        for (i in randomNumbers.indices) {
            randomNumbers[i] = random.nextInt(max)
        }
        Arrays.sort(randomNumbers)
        return randomNumbers
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)




        Handler().postDelayed({


            ConfigurationFile.setCurrentLanguage(this, "en")
            if (!LoginSession.isLoggedIn(this@SplashActivity)) IntentClass.goToActivityAndClear(
                this@SplashActivity,
                AddFeedbackActivity::class.java, null
            ) else {
                IntentClass.goToActivityAndClear(
                    this@SplashActivity,
                    MainActivity::class.java,
                    null
                )
            }
        }, 2000)
    }
}