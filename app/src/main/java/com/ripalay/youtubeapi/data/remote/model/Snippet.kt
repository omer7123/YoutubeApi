package com.ripalay.youtubeapi.data.remote.model

data class Snippet(
    val channelId: String?,
    val channelTitle: String?,
    val defaultLanguage: String?,
    val description: String?,
    val localized: Localized?,
    val publishedAt: String?,
    val thumbnails: Thumbnails?,
    val title: String?
)