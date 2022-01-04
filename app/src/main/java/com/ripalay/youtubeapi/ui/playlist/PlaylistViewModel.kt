package com.ripalay.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import com.ripalay.App
import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.data.remote.model.Items
import com.ripalay.youtubeapi.data.remote.model.Playlist

class PlaylistViewModel : BaseViewModel() {
    fun getPlayList(): LiveData<Playlist> {
        return App().repository.createPlaylist()
    }
}