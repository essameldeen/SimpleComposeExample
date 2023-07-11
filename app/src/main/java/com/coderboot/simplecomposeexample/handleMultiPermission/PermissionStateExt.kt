package com.coderboot.simplecomposeexample.handleMultiPermission

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

@OptIn(ExperimentalPermissionsApi::class)
fun PermissionState.isPermissionDenied(): Boolean {
    return !shouldShowRationale && ! hasPermission
}