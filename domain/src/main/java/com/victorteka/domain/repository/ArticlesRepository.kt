package com.victorteka.domain.repository


import com.victorteka.domain.Result
import com.victorteka.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    fun getArticles(apiKey: String): Flow<Result<List<Article>>>

}