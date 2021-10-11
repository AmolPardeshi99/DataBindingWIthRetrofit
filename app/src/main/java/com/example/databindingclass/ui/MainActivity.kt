package com.example.databindingclass.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingclass.R
import com.example.databindingclass.adapters.MoviesAdapter
import com.example.databindingclass.databinding.ActivityMainBinding
import com.example.databindingclass.hilt.Module
import com.example.databindingclass.model.Result
import com.example.databindingclass.repo.MovieRepo
import com.example.databindingclass.viewModel.MovieViewModel
import com.example.databindingclass.viewModel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var moviesAdapter: MoviesAdapter
    lateinit var movieViewModel: MovieViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    var movieList = mutableListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        movieViewModel = ViewModelProviders.of(this,ViewModelFactory(MovieRepo(Module.getApiService()))).
        get(MovieViewModel::class.java)

        activityMainBinding.apply {
            moviesAdapter = MoviesAdapter(movieList)
            recyclerView1.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView1.adapter = moviesAdapter
        }

            movieViewModel.getAPiData().observe(this, Observer{
                movieList.clear()
                movieList.addAll(it)
                moviesAdapter.notifyDataSetChanged()
            })



    }
}