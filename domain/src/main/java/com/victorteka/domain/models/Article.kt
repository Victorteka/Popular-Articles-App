package com.victorteka.domain.models

data class Article(
    val title: String,
    val published_date: String,
    val source: String,
    val section: String,
    val url: String,
    val byline: String,
    val media: List<Media>
)

data class Media(
    val approvedForSyndication: Int,
    val caption: String,
    val copyright: String,
    val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)

data class MediaMetadata(
    val format: String,
    val height: Int,
    val url: String,
    val width: Int
)
