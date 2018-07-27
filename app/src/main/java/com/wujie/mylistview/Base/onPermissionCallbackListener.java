package com.wujie.mylistview.Base;

import java.util.List;

public interface onPermissionCallbackListener {
    void onGranted();

    void onDenied(List<String> deniedPermissions);
}
