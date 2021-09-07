package com.victorteka.domain.service

import com.victorteka.domain.Result
import com.victorteka.domain.models.GetArticlesResponse

interface ArticleService {

    suspend fun getArticles(): Result<GetArticlesResponse>

}