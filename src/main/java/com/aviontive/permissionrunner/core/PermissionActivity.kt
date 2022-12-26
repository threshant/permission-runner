package com.aviontive.permissionrunner.core

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.aviontive.permissionrunner.ui.DescriptionFragment
import com.aviontive.permissionrunner.ui.StrictFragment
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class PermissionActivity : AppCompatActivity() {
    private lateinit var callback: PermissionCallback
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var requestedPermissions:ArrayList<Permission>
    private var grantedList = ArrayList<String>()
    private var deniedList = ArrayList<String>()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedPermissions = intent.extras!!.get(PermissionRunner.PERMISSION_LIST) as ArrayList<Permission>
        callback = intent.getSerializableExtra(PermissionRunner.PERMISSION_CALLBACK) as PermissionCallback
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
            for((key,value) in it){
                if(value){
                    grantedList.add(key)
                }
                else{
                    deniedList.add(key)
                    val match = requestedPermissions.stream().filter { p -> p.name==key }.collect(Collectors.toList())
                    if(match[0].isMandatory){
                        showStrictSheet()
                    }
                }
            }
            callback.onSuccess(grantedList,deniedList)
        }

        if(intent.extras!!.get(PermissionRunner.PERMISSION_DESCRIPTION) as Boolean){
            showDescriptionSheet()
        }
        else{
            launchPermissions()
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun showDescriptionSheet(){
        val descriptionFragment = DescriptionFragment(requestedPermissions){
            launchPermissions()
        }
        descriptionFragment.show(supportFragmentManager, "TAG")

    }

    fun showStrictSheet(){
        StrictFragment().apply {
            show(supportFragmentManager,"TAG")
            isCancelable = false
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun launchPermissions(){
        val permissions = requestedPermissions.stream().map(Permission::name).collect(Collectors.toList())
        permissionLauncher.launch(permissions!!.toTypedArray())

    }

}