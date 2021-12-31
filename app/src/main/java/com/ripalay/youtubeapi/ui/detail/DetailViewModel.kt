package com.ripalay.youtubeapi.ui.detail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.youtubeapi.base.BaseViewModel

class DetailViewModel : BaseViewModel() {
    fun getIntent(intent: Intent): LiveData<String> {
        var id = MutableLiveData<String>()
        id.value = intent.getStringExtra("ID")
        return id
    }
}