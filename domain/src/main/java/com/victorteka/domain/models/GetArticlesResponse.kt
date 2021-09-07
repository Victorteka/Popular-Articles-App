package com.victorteka.domain.models

data class GetArticlesResponse(
    val result: List<Article>,
    val status: String,
    val numResults: Int
)
