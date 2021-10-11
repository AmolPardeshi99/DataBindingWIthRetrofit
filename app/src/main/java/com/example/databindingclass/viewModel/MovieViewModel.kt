package com.example.databindingclass.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.databindingclass.model.Result
import com.example.databindingclass.repo.MovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(val repo: MovieRepo):ViewModel() {

    fun getAPiData():LiveData<List<Result>>{
        return liveData(Dispatchers.IO){
            emit(repo.getAPIResponse())
        }
    }
}