package com.victorteka.data.network.di

import com.google.gson.Gson
import com.victorteka.data.network.NYTApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    /*@Provides
    @Singleton
    fun provideOkhttpClientToken(logging: HttpLoggingInterceptor) =
        OkHttpClient.Builder().apply {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            addInterceptor(AuthInterceptor())
            addInterceptor(logging) //Wrap in debug
        }.build()*/

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideNYTApi(retrofit: Retrofit): NYTApi = retrofit.create(NYTApi::class.java)
}