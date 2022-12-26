package com.aviontive.permissionrunner.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface PermissionCallback extends Serializable {
    void onSuccess(ArrayList<String> grantedPermissions, ArrayList<String> deniedPermission);
}
