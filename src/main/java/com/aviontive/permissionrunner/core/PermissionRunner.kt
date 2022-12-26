package com.aviontive.permissionrunner.core

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class PermissionRunner(activity: Activity){

    private var currentActivity = activity
    var showDescriptionDialogue = false
    private lateinit var permissionCallback: PermissionCallback
    @RequiresApi(Build.VERSION_CODES.M)
    fun getPermissions(permissions:ArrayList<Permission>, permissionCallback: PermissionCallback){
        this.permissionCallback = permissionCallback
        val intent = Intent(currentActivity, PermissionActivity::class.java)
        intent.putExtra(PERMISSION_LIST, permissions)
        intent.putExtra(PERMISSION_DESCRIPTION, showDescriptionDialogue)
        intent.putExtra(PERMISSION_CALLBACK,permissionCallback)
        currentActivity.startActivity(intent)
    }



    fun checkPermissions(){

    }

    companion object{
        val PERMISSION_LIST = "permission_list"
        val PERMISSION_CALLBACK = "permission_callback"
        val PERMISSION_DESCRIPTION = "permission_description"
    }

}