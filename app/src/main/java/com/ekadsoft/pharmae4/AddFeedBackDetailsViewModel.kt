package com.ekadsoft.pharmae4

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Images.imagePicker.Camera
import com.ekadsoft.pharmae4.View.Activities.AddFeedbackActivity

class AddFeedBackDetailsViewModel : ViewModel() {


    lateinit var activity: AddFeedbackActivity
    var type = ObservableInt()


    init {
        type = ObservableInt(1)
    }


    fun back() {

        activity.finish()

    }

    fun save() {

        activity.finish()

    }




    fun addImage() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    activity, arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ), 3
                )
            } else {
                Camera.showGallery(activity)
            }
        } else {
            Camera.showGallery(activity)
        }
    }






}