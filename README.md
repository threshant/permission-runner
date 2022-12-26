# Permission Runner

A simple library to request runtime permission in Android

## Installation

Add the following line to your gradle file

```bash

```

## Usage

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
