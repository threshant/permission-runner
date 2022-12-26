<p align="center"><img src="https://socialify.git.ci/threshant/permission-runner/image?language=1&amp;name=1&amp;pattern=Plus&amp;theme=Dark" alt="project-image"></p>

<p id="description">A simple customizable android library to request and manage runtime permission in Android</p>


## Installation

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
Add the dependency

```bash
dependencies {
	        implementation 'com.github.threshant:permission-runner:v1.0.0'
	}
```

## Example

<img src="https://github.com/threshant/permission-runner/blob/master/explainer.gif" width="200">


Code for the above demo
```kotlin
 PermissionRunner(this).apply {
            showDescriptionDialogue = true
            getPermissions(arrayListOf(
                Permission(Manifest.permission.CAMERA,true,"Need camera permission to access QR Scanner"),
                Permission(Manifest.permission.CALL_PHONE,false,"Need phone permission to access Friends"),
                Permission(Manifest.permission.ACCESS_COARSE_LOCATION,true,"Need location permission to access current PinCode"),
            )
            ) { grantedPermissions, deniedPermission ->
                Log.d("Granted", grantedPermissions.toString())
                Log.d("Denied", deniedPermission.toString())
            }
        }
```
## How to use
1. The permission class: 
This is used to define custom inputs for each individual permission, it requires three parameters
- PermissionName:String
- isMandatory:Boolean
- description:String (optional)
```kotlin
  Permission(permissionName, isMandatory, description)
```
2. showDescriptionDialogue: 
This option is used to show a buttom sheet of the list of permissions before requesting them
```kotlin
  showDescriptionDialogue = true
```
3. getPermissions:
This method is used to request the runtime permission, this requires two parameters
- ArrayList of Permission
- A callback function
```kotlin
  getPermissions(arrayListOf(
                Permission(Manifest.permission.CAMERA,true,"Need camera permission to access QR Scanner"),
                Permission(Manifest.permission.CALL_PHONE,false,"Need phone permission to access Friends"),
                Permission(Manifest.permission.ACCESS_COARSE_LOCATION,true,"Need location permission to access current PinCode"),
            )
            ) { grantedPermissions, deniedPermission ->
                Log.d("Granted", grantedPermissions.toString())
                Log.d("Denied", deniedPermission.toString())
            }
```
4. Putting it all together: 
```kotlin
 PermissionRunner(this).apply {
            showDescriptionDialogue = true
            getPermissions(arrayListOf(
                Permission(Manifest.permission.CAMERA,true,"Need camera permission to access QR Scanner"),
                Permission(Manifest.permission.CALL_PHONE,false,"Need phone permission to access Friends"),
                Permission(Manifest.permission.ACCESS_COARSE_LOCATION,true,"Need location permission to access current PinCode"),
            )
            ) { grantedPermissions, deniedPermission ->
                Log.d("Granted", grantedPermissions.toString())
                Log.d("Denied", deniedPermission.toString())
            }
        }
```


## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
