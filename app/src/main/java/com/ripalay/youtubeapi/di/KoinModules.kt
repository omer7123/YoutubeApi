package com.ripalay.youtubeapi.di

import com.ripalay.youtubeapi.core.network.networkModule
import com.ripalay.youtubeapi.data.remote.remoteDataSource

val koinModules = listOf(
    repoModules,
    viewModules,
    networkModule,
    remoteDataSource
)