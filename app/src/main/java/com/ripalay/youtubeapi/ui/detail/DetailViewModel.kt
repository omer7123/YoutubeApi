package com.ripalay.youtubeapi.ui.detail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.App
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.network.result.Resource
import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.repository.Repository

class DetailViewModel(private val repository: Repository) : BaseViewModel() {
    var loading = MutableLiveData<Boolean>()


    fun getPlay(id: String?): LiveData<Resource<Playlist>> {
        return repository.createPlay(id)
    }
}