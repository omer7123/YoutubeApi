package com.ripalay

import android.app.Application
import com.ripalay.youtubeapi.core.network.RetrofitClient
import com.ripalay.youtubeapi.repository.Repository

class App : Application() {
    val repository by lazy {
        Repository()
    }

    val youtubeApi by lazy { RetrofitClient.create() }

}