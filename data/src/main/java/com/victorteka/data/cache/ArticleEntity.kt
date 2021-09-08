package com.victorteka.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "published_date")
    val publishedDate: String,

    @ColumnInfo(name = "source")
    val source: String,

    @ColumnInfo(name = "section")
    val section: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "byline")
    val byline: String
)
