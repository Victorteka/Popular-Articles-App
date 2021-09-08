package com.victorteka.data.cache.di

import android.content.Context
import com.victorteka.data.cache.ArticleDao
import com.victorteka.data.cache.NYTArticlesDB
import com.victorteka.data.network.repository.ArticleRepoImpl
import com.victorteka.domain.ArticlesService
import com.victorteka.domain.repository.ArticlesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheDI {

    @Provides
    @Singleton
    internal fun provideArticleDatabase(context: Context): NYTArticlesDB =
        NYTArticlesDB.getInstance(context)

    @Provides
    @Singleton
    internal fun provideArticleStatsDao(database: NYTArticlesDB): ArticleDao =
        database.articleDao()

    @Provides
    @Singleton
    internal fun provideArticleRepository(
        articleDao: ArticleDao,
        articlesService: ArticlesService
    ): ArticlesRepository = ArticleRepoImpl(articleDao, articlesService)
}