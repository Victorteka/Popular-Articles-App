package com.victorteka.nytarticles.ui.home

import androidx.lifecycle.*
import com.victorteka.data.network.usecases.GetArticlesUseCase
import com.victorteka.domain.Result
import com.victorteka.domain.models.Article
import com.victorteka.domain.repository.ArticlesRepository
import com.victorteka.domain.utils.Resource
import com.victorteka.nytarticles.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val apiKey = BuildConfig.NYT_API_KEY
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    init {
        getArticles(apiKey)
    }

    private fun getArticles(apiKey: String) {
        getArticlesUseCase(apiKey).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _articles.value = result.data ?: emptyList()
                }
                /*is Resource.Error -> {
                    _articles.value = result.message ?: "Unexpected error occurred!"
                }
                is Resource.Loading -> {
                    _articles.value = ""
                }*/
            }
        }.launchIn(viewModelScope)
    }

}