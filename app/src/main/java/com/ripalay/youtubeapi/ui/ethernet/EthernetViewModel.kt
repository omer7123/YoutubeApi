package com.ripalay.youtubeapi.ui.ethernet

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.youtubeapi.base.BaseViewModel
import java.net.InetAddress
import java.net.InetAddress.getByName

class EthernetViewModel : BaseViewModel() {
    private val isConnected = MutableLiveData<Boolean>()
    fun isOnline(context: Context): LiveData<Boolean> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.e("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    isConnected.value = true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.e("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    isConnected.value = true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.e("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    isConnected.value = true
                }
            }else{
                isConnected.value = false
            }
        }
        return isConnected
    }

}