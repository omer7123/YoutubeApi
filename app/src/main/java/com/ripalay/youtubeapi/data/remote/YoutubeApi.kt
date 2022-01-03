package com.ripalay.youtubeapi.data.remote

import com.ripalay.youtubeapi.data.remote.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String):
            Call<Playlist>
}