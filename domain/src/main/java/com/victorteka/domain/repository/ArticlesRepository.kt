package com.victorteka.domain.repository


import com.victorteka.domain.models.Article

interface ArticlesRepository {

    suspend fun getArticles(apiKey: String): List<Article>

}