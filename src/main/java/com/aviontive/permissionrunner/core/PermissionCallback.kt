package com.aviontive.permissionrunner.core

import java.io.Serializable

interface PermissionCallback : Serializable {
    fun onSuccess(grantedPermissions: ArrayList<String>, deniedPermission: ArrayList<String>)
}