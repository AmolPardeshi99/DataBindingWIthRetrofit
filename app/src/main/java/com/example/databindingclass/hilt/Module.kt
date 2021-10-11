package com.example.databindingclass.hilt

import com.example.databindingclass.model.remote.APiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object Module {

    private val baseUrl = "https://api.themoviedb.org/3/"

    @Provides
    fun getApiService():APiService{
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APiService::class.java)
    }
}