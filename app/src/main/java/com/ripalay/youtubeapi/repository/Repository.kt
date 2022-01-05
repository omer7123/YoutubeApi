package com.ripalay.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.App
import com.ripalay.youtubeapi.BuildConfig
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.data.remote.model.Playlist
import retrofit2.Call
import retrofit2.Response

class Repository {

    fun createPlaylist(): LiveData<Playlist> {

        val data = MutableLiveData<Playlist>()
        App().youtubeApi.getPlaylists(Constant.PART, Constant.CHANNEL_ID, BuildConfig.API_KEY)
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

    fun createPlay(id: String?): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()
        App().youtubeApi.getPlaylist(Constant.PART, id, BuildConfig.API_KEY,"50")
            .enqueue(object : retrofit2.Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {

                }
            })
        return data

    }

}