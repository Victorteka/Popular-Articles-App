package com.victorteka.domain.models

data class ArticlesResponse(
    val results: List<Article>,
    val status: String,
    val numResults: Int
)
