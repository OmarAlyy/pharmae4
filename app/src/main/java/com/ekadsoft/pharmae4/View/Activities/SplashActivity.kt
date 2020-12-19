package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.SharedPreferences.ConfigurationFile
import com.ekadsoft.pharmae4.SharedPreferences.LoginSession
import com.ekadsoft.pharmae4.Utilities.IntentClass


class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val image: ImageView = findViewById(R.id.image)
        val animation =
            AnimationUtils.loadAnimation(
                this@SplashActivity,
                R.anim.slide_in_left
            )
        image.animation = animation

        Handler().postDelayed({


            ConfigurationFile.setCurrentLanguage(this, "en")
            if (!LoginSession.isLoggedIn(this@SplashActivity)) IntentClass.goToActivityAndClear(
                this@SplashActivity,
                LoginActivity::class.java, null
            ) else {
                IntentClass.goToActivityAndClear(
                    this@SplashActivity,
                    MainActivity::class.java,
                    null
                )
            }
        }, 3000)
    }
}