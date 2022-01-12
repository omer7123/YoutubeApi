package com.ripalay.youtubeapi.di

import com.ripalay.youtubeapi.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules: Module = module {
    single {Repository(get())}
}