package com.victorteka.data.network.models


import com.google.gson.annotations.SerializedName

data class ArticleApiResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<Any>,
    @SerializedName("status")
    val status: String
)