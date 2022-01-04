package com.ripalay.youtubeapi.data.remote.model

data class Playlist(
    //   var kind: String? = null,
    var items: List<Items>,
    var pageInfo: PageInfo
)

data class PageInfo (
    val totalResults: String
)
