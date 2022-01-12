package com.ripalay.youtubeapi.ui.third

import androidx.lifecycle.LiveData
import com.ripalay.youtubeapi.core.network.result.Resource
import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.repository.Repository

class ThirdViewModel(private val repository: Repository) : BaseViewModel() {
    fun getVideo(id:String) : LiveData<Resource<Playlist>>{
        return repository.getVideo(id)
    }
}