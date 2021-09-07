package com.victorteka.data.network.repository

import com.victorteka.data.cache.ArticleDao
import com.victorteka.data.cache.toDomain
import com.victorteka.data.cache.toEntity
import com.victorteka.data.network.NYTApi
import com.victorteka.domain.ArticlesService
import com.victorteka.domain.Result
import com.victorteka.domain.models.Article
import com.victorteka.domain.models.ArticlesResponse
import com.victorteka.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class ArticleRepoImpl @Inject constructor(
    private val articleDao: ArticleDao,
    private val articlesService: ArticlesService
) : ArticlesRepository {

    override fun getArticles(apiKey: String): Flow<Result<List<Article>>> = flow {
        emit(Result.Loading)

        if (articleDao.count() == 0) {
            when (val result = articlesService.getArticles(apiKey)) {
                is Result.Error -> emit(Result.error(result.exception))
                is Result.Success -> {
                    val entities = result.data.results.map {
                        it.toEntity()
                    }
                    articleDao.saveArticle(entities)

                }
            }
        }else{
            articleDao.getCache().collect { list ->
                emit(Result.Success(list.map { it.toDomain() }))
            }
        }
    }
}