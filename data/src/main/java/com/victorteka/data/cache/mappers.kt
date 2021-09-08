package com.victorteka.data.cache

import com.victorteka.domain.models.Article


internal fun Article.toEntity() = ArticleEntity(
    null,
    this.title,
    this.published_date,
    this.source,
    this.section,
    this.url,
    this.byline
)

internal fun ArticleEntity.toDomain() = Article(
    this.title,
    this.publishedDate,
    this.source,
    this.section,
    this.url,
    this.byline
)