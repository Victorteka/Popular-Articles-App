package com.victorteka.domain.repository


import com.victorteka.domain.DataResult
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    fun getArticles(apiKey: String): Flow<DataResult>
}