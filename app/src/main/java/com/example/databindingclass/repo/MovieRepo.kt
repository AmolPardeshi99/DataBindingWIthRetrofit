package com.example.databindingclass.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.databindingclass.model.Result
import com.example.databindingclass.model.remote.APiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MovieRepo @Inject constructor(private val aPiService: APiService) {

    suspend fun getAPIResponse(): List<Result> {
        return aPiService.getApiResponse().results
    }

}