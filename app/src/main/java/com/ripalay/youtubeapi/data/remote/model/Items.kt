package com.ripalay.youtubeapi.data.remote.model

data class Items(
    val contentDetails: ContentDetails?,
    val etag: String,
    val id: String,
    val kind: String? = null,
    val snippet: Snippet,
)
