package com.victorteka.data.network

import com.victorteka.domain.DataResult
import com.victorteka.domain.models.Article
import com.victorteka.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleRepoImpl(private val nytApi: NYTApi) : ArticlesRepository {

    override fun getArticles(apiKey: String): Flow<DataResult> = flow {
        val response = nytApi.getArticles(apiKey)
    }
}