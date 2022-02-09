package com.example.ocmr.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import javax.inject.Inject

class PermissionUtil @Inject constructor() {
    fun checkPermissions(context: Context, permissions: Array<String>) = permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    fun requestMultiplePermission (fragment: Fragment, arrayPermission: Array<String>, listener: (isGranted: Boolean?) -> Unit) {
        val requestMultiplePermission = fragment.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            listener.invoke(permissions.entries.find { it -> it.value == false } != null)

            permissions.entries.forEach {
                Log.e("PERMISSION", "${it.key} has value is ${it.value}")
            }
        }

        requestMultiplePermission.launch(arrayPermission)
    }

    fun requestSinglePermission(fragment: Fragment, permission: String, listener: (isGranted: Boolean?) -> Unit) {
        val requestSinglePermission = fragment.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            Log.e("PERMISSION", "$permission has value is $it")
            listener.invoke(it)
        }

        requestSinglePermission.launch(permission)
    }


}