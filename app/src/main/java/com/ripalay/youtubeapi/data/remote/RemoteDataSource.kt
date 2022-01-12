package com.ripalay.youtubeapi.data.remote

import com.ripalay.youtubeapi.BuildConfig
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val youtubeApi: YoutubeApi): BaseDataSource() {

    suspend fun getPlaylists() = getResult{
        youtubeApi.getPlaylists(Constant.PART, Constant.CHANNEL_ID, BuildConfig.API_KEY)
    }
    suspend fun getPlaylistItems(id: String?) = getResult{
        youtubeApi.getPlaylist(Constant.PART, id, BuildConfig.API_KEY, "50")
    }
    suspend fun getVideo(id: String?) = getResult {
        youtubeApi.getVideo(Constant.PART, id.toString(), BuildConfig.API_KEY)
    }
}