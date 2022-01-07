package com.ripalay.youtubeapi.data.remote

import com.ripalay.youtubeapi.data.remote.model.Playlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    suspend fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String
    ):
            Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylist(
        @Query("part") part: String,
        @Query("playlistId") playId: String?,
        @Query("key") key: String,
        @Query("maxResults") num: String
    ):
            Response<Playlist>
}