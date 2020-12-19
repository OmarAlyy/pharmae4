package com.ekadsoft.pharmae4.View.Activities

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.AddFeedBackDetailsViewModel
import com.ekadsoft.pharmae4.Images.ImageSelectActivity
import com.ekadsoft.pharmae4.Images.imagePicker.Camera
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.View.Adapters.AttachmentFilesAdapter
import com.ekadsoft.pharmae4.databinding.ActivityFeedbackSummaryBinding
import java.io.File
import java.util.ArrayList

class FeedbackSummaryActivity : AppCompatActivity() {



    var type = 1

    lateinit var binding: ActivityFeedbackSummaryBinding
    lateinit var viewmodel: AddFeedBackDetailsViewModel
    lateinit var adabterImages: AttachmentFilesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback_summary)


        viewmodel = ViewModelProviders.of(this).get(AddFeedBackDetailsViewModel::class.java)
        viewmodel!!.activity = this
        var bundle = intent.getBundleExtra("data")
        try {
            type = bundle.getInt("type")
        } catch (e: Exception) {
        }
        viewmodel.type.set(type)
        binding?.viewmodel = viewmodel
        adabterImages = AttachmentFilesAdapter(this, ArrayList())
        binding.listImages.adapter = adabterImages

    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        try {
            if (requestCode == Camera.GALLERY_REQUEST) {
                val filePath =
                    data!!.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH)
                val selectedImage = BitmapFactory.decodeFile(filePath)
                val file: File = Camera.getFilePic(selectedImage, this)
                if (file.exists()) {
                    Log.e("absolutePath" , file.absolutePath)
                    adabterImages.list.add(file.absolutePath)
                    adabterImages.notifyDataSetChanged()
                    Log.e("listlist" ,  adabterImages.list.size.toString())

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if (grantResults.size > 0 && grantResults[0] === PackageManager.PERMISSION_GRANTED) {

            Camera.showGallery(this)

        }
    }
}