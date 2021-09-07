package com.victorteka.domain

import com.victorteka.domain.models.ArticlesResponse

interface ArticlesService {

    suspend fun getArticles(apiKey: String): Result<ArticlesResponse>
}