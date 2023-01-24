package com.arabin.luanchdarkly_arabin_sse.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public class NetWorkUtil {

    public static boolean hasInternetConnection(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            Network network = manager.getActiveNetwork();
            if (network == null)
                return false;
            else {
                NetworkCapabilities capabilities = manager.getNetworkCapabilities(network);
                return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
            }
        }else{
            NetworkInfo info = manager.getActiveNetworkInfo();
            return info != null && info.isConnected();
        }
    }

}
