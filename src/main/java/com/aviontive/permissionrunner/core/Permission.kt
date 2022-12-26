package com.aviontive.permissionrunner.core

import java.io.Serializable

data class Permission(
    var name:String,
    var isMandatory:Boolean,
    var description:String = ""
) : Serializable
