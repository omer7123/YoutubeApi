package com.ripalay.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ripalay.youtubeapi.core.network.result.Resource
import com.ripalay.youtubeapi.data.remote.RemoteDataSource
import com.ripalay.youtubeapi.data.remote.model.Playlist
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {

    fun createPlayList(): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
//        val response =
//            App().youtubeApi.getPlaylists(Constant.PART, Constant.CHANNEL_ID, BuildConfig.API_KEY)
//        if (response.isSuccessful && response.body() != null) {
//            emit(Resource.success(response.body()))
//        } else {
//            emit(Resource.error(response.message(), response.body(), response.code()))
//        }
        val response = dataSource.getPlaylists()
        emit(response)
    }

    fun createPlay(id: String?): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
//        val response = App().youtubeApi.getPlaylist(Constant.PART, id, BuildConfig.API_KEY, "50")
//        if (response.isSuccessful && response.body() != null) {
//            emit(Resource.success(response.body()))
//        } else {
//            emit(Resource.error(response.message(), response.body(), response.code()))
//        }
//    }
        val response = dataSource.getPlaylistItems(id)
        emit(response)
    }
    fun getVideo(id: String?): LiveData<Resource<Playlist>> = liveData (Dispatchers.IO){
        emit(Resource.loading())
        val response = dataSource.getVideo(id)
        emit(response)
    }
}
//    fun createPlaylist(): LiveData<Playlist> {
//
//        val data = MutableLiveData<Playlist>()
//        App().youtubeApi.getPlaylists(Constant.PART, Constant.CHANNEL_ID, BuildConfig.API_KEY)
//            .enqueue(object : retrofit2.Callback<Playlist> {
//                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
//                    if (response.isSuccessful && response.body() != null) {
//                        data.value = response.body()
//                    }
//                }
//
//                override fun onFailure(call: Call<Playlist>, t: Throwable) {
//                    print(t.stackTrace)
//                }
//
//            })
//        return data
//    }

//    fun createPlay(id: String?): LiveData<Playlist> {
//        val data = MutableLiveData<Playlist>()
//        App().youtubeApi.getPlaylist(Constant.PART, id, BuildConfig.API_KEY, "50")
//            .enqueue(object : retrofit2.Callback<Playlist> {
//                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
//                    if (response.isSuccessful && response.body() != null) {
//                        data.value = response.body()
//                    }
//                }
//
//                override fun onFailure(call: Call<Playlist>, t: Throwable) {
//
//                }
//            })
//        return data
//
//    }
//
//}