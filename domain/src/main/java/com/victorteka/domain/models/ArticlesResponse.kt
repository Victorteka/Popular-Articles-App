package com.victorteka.domain.models

data class ArticlesResponse(
    val result: List<Article>,
    val status: String,
    val numResults: Int
)
