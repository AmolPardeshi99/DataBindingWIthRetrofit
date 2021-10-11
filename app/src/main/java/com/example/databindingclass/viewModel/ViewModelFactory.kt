package com.example.databindingclass.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.databindingclass.repo.MovieRepo

class ViewModelFactory(private val repo:MovieRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repo) as T
    }
}