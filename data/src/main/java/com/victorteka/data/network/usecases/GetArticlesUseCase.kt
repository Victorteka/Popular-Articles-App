package com.victorteka.data.network.usecases

import com.victorteka.domain.models.Article
import com.victorteka.domain.repository.ArticlesRepository
import com.victorteka.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val articlesRepository: ArticlesRepository) {

    operator fun invoke(apiKey: String): Flow<Resource<List<Article>>> = flow {
        try {
            emit(Resource.Loading<List<Article>>())
            val articles = articlesRepository.getArticles(apiKey)
            emit(Resource.Success(articles))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Article>>("Couldn't reach server, check your internet connection!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Article>>(e.localizedMessage ?: "An unknown error occured"))
        }
    }
}
