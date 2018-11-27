package com.zalyyh.yyh.app_zal;

import android.content.Context;
import android.net.wifi.WifiManager;

public class ZWifiManager {

    /**
     * wifi管理者
     */
    protected static WifiManager hwifiManager;
    // 定义一个WifiLock
    protected WifiManager.WifiLock mWifiLock;





    // 检查当前WIFI状态

    public int checkState(Context context) {
        return hwifiManager.getWifiState();
    }

    //判断对象是否为空
    public boolean isObject(Object o) {
        if (o != null)
            return true;
        else return false;
    }
}
