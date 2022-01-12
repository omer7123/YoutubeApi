package com.ripalay.youtubeapi.di

import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.ui.detail.DetailViewModel
import com.ripalay.youtubeapi.ui.ethernet.EthernetViewModel
import com.ripalay.youtubeapi.ui.playlist.PlaylistViewModel
import com.ripalay.youtubeapi.ui.third.ThirdViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { BaseViewModel() }
    viewModel { EthernetViewModel() }
    viewModel { ThirdViewModel(get()) }
}