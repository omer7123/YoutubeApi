package com.ripalay.youtubeapi.ui.detail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.App
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.data.remote.model.Playlist

class DetailViewModel : BaseViewModel() {
    fun getIntent(intent: Intent): LiveData<String> {
        var id = MutableLiveData<String>()
        id.value = intent.getStringExtra(Constant.ID)
        return id
    }
    fun getPlay(id: String?): LiveData<Playlist> {
        return App().repository.createPlay(id)
    }
}