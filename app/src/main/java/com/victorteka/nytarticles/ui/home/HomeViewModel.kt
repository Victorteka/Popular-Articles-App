package com.victorteka.nytarticles.ui.home

import androidx.lifecycle.*
import com.victorteka.domain.Result
import com.victorteka.domain.models.Article
import com.victorteka.domain.repository.ArticlesRepository
import com.victorteka.nytarticles.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articlesRepository: ArticlesRepository
) : ViewModel() {
    private val apiKey = BuildConfig.NYT_API_KEY
    val articles = articlesRepository.getArticles(apiKey).asLiveData()
}