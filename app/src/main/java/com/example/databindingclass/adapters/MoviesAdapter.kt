package com.example.databindingclass.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.databindingclass.R
import com.example.databindingclass.databinding.ItemLayoutBinding
import com.example.databindingclass.model.Result

class MoviesAdapter(
    private val moviewList: List<Result>
):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.setModel(moviewList[position])
    }

    override fun getItemCount(): Int {
       return moviewList.size
    }

    class MoviesViewHolder(private val itemLayoutBinding: ItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBinding.root){

        fun setModel(result: Result){
            itemLayoutBinding.result = result
            Glide.with(itemLayoutBinding.ivMovieImg).load("https://image.tmdb.org/t/p/w500/"+result.backdropPath).into(itemLayoutBinding.ivMovieImg)
        }
    }
}