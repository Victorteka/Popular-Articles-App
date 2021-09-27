package com.victorteka.data.network

import com.victorteka.data.network.dto.ArticleDto
import com.victorteka.domain.models.Article

fun Article.toDto(): ArticleDto = ArticleDto(
    url = this.url,
    title = this.title,
    source = this.source,
    media = listOf(),
    section = this.section,
    publishedDate = this.published_date,
    byline = this.byline
)
