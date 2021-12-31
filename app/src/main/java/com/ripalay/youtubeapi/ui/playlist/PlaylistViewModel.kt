package com.ripalay.youtubeapi.ui.playlist

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.youtubeapi.BuildConfig.API_KEY
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.base.BaseViewModel
import com.ripalay.youtubeapi.model.Playlist
import com.ripalay.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {
    private val youtubeApi = RetrofitClient.create()
    fun getPlayList(): LiveData<Playlist> {
        return createPlaylist()
    }

    private fun createPlaylist(): LiveData<Playlist> {

        val data = MutableLiveData<Playlist>()
        youtubeApi.getPlaylists(Constant.PART, Constant.CHANNEL_ID, API_KEY)
            .enqueue(object : retrofit2.Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    print(t.stackTrace)
                }

            })
        return data
    }





}