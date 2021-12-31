package com.ripalay.youtubeapi.model

data class Items(
    val contentDetails: ContentDetails?,
    val etag: String,
    val id: String,
    val kind: String? = null,
    val snippet: Snippet,
)
