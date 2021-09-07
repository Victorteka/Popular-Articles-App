package com.victorteka.data.network

import com.victorteka.data.network.RetrofitUtil.safeApiCall
import com.victorteka.domain.ArticlesService
import com.victorteka.domain.Result
import com.victorteka.domain.models.ArticlesResponse
import javax.inject.Inject

class ArticleServiceImpl @Inject constructor(private val nytApi: NYTApi): ArticlesService {

    override suspend fun getArticles(apiKey: String): Result<ArticlesResponse> = safeApiCall{
        nytApi.getArticles(apiKey)
    }
}