package com.example.databindingclass.model.remote

import com.example.databindingclass.model.MovieResponse
import com.example.databindingclass.model.Result
import retrofit2.http.GET

interface APiService {

    @GET("movie/popular?api_key=938b689ac12d1d01204c4416d9f12a68")
    suspend fun getApiResponse():MovieResponse
}