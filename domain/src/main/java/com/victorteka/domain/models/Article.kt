package com.victorteka.domain.models

data class Article(
    val title: String,
    val published_date: String,
    val source: String,
    val section: String,
    val url: String,
    val byline: String
)
