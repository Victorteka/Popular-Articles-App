package com.victorteka.domain

import com.victorteka.domain.models.ArticlesResponse

sealed class DataResult {
    data class Success(val articlesResponse: ArticlesResponse) : DataResult()
    data class Error(val message: String) : DataResult()
    object Loading : DataResult()
}