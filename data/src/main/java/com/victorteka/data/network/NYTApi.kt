package com.victorteka.data.network

import com.victorteka.domain.models.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTApi {

    @GET("viewed/7.json")
    suspend fun getArticles(@Query("api-key")apiKey: String): Response<ArticlesResponse>

}