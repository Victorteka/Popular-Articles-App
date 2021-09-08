package com.victorteka.nytarticles.ui.home

import androidx.lifecycle.*
import com.victorteka.domain.Result
import com.victorteka.domain.models.Article
import com.victorteka.domain.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articlesRepository: ArticlesRepository
) : ViewModel() {

    val articles = articlesRepository.getArticles("20UGZGTAxVquIscwTzzKv9fteZQ6ZWuO").asLiveData()
}