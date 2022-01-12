package com.ripalay.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.App
import com.ripalay.youtubeapi.core.network.result.Resource
import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.data.remote.model.Items
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.repository.Repository

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun getPlayList(): LiveData<Resource<Playlist>> {
        return repository.createPlayList()
    }
}