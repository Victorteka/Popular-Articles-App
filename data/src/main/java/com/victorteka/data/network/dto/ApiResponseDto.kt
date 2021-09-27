package com.victorteka.data.network.dto


import com.google.gson.annotations.SerializedName

data class ApiResponseDto(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<ArticleDto>,
    @SerializedName("status")
    val status: String
)