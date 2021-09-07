package com.victorteka.data.network

import com.victorteka.data.network.models.ArticleApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTApi {

    @GET("viewed/7.json")
    suspend fun getArticles(@Query("api-key")apiKey: String): Response<ArticleApiResponse>

}