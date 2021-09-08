package com.victorteka.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ArticleDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveArticle(articleEntities: List<ArticleEntity>)

    @Query("select * from popular_articles")
    fun getCache(): Flow<List<ArticleEntity>>

    @Query("select exists (select 1 from popular_articles)")
    suspend fun exists(): Boolean

    @Query("select count(*) from popular_articles")
    suspend fun count(): Int
}