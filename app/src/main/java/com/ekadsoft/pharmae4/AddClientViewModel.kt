package com.ekadsoft.pharmae4

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.ekadsoft.pharmae4.Images.imagePicker.Camera
import com.ekadsoft.pharmae4.Utilities.GlobalVariables
import com.ekadsoft.pharmae4.Utilities.IntentClass
import com.ekadsoft.pharmae4.View.Activities.AddNewBranchActivity
import com.ekadsoft.pharmae4.View.Activities.AddNewClientActivity
import com.ekadsoft.pharmae4.View.Fragments.SelectCheckBoxFragmentDialog
import com.ekadsoft.pharmae4.View.Fragments.SelectRadioFragmentDialog

class AddClientViewModel : ViewModel() {


    var clientTypeObservableField: ObservableField<String> = ObservableField("Client Type")
    var clientTypeObservableFieldId: ObservableField<String> = ObservableField("")


    var clientEntityObservableField: ObservableField<String> = ObservableField("Client Type")
    var clientEntityObservableFieldID: ObservableField<String> = ObservableField("Client Type")

    var clientChooseObservableField: ObservableField<String> = ObservableField("Client Type")
    var clientChooseObservableFieldId: ObservableField<String> = ObservableField("")



    var isNoClients: ObservableBoolean = ObservableBoolean(false)


    lateinit var activity: AddNewClientActivity
    var type = ObservableInt()

    var typeSelect = 0;

    init {
        type = ObservableInt(1)
    }


    fun back() {

        activity.finish()

    }


    fun save() {

        activity.finish()

    }


    fun openClientType() {

        typeSelect = 1
        SelectRadioFragmentDialog(
            "Client Type", this, typeSelect
        ).show(activity!!.supportFragmentManager, "")

    }


    fun openEntityClient() {


        typeSelect = GlobalVariables.TYPE_EntityClient
        SelectRadioFragmentDialog(
            "Entity Client", this, typeSelect
        ).show(activity!!.supportFragmentManager, "")


    }

    fun openChooseClient() {


        typeSelect = GlobalVariables.TYPE_Choose_Client
        SelectRadioFragmentDialog(
            "Choose Client", this, typeSelect
        ).show(activity!!.supportFragmentManager, "")


    }


    fun openBranche() {


        typeSelect = GlobalVariables.TYPE_BRANCH
        SelectCheckBoxFragmentDialog(
            "Branche Name", this, typeSelect
        ).show(activity!!.supportFragmentManager, "")

    }


    fun addNewClient() {
        isNoClients.set(!isNoClients.get())

    }

    fun addNewBranch() {


        IntentClass.goToActivity(
            activity,
            AddNewBranchActivity::class.java,
            null
        )

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