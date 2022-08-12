package com.example.callapibyrxjava02.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.callapibyrxjava02.databinding.ItemMoviesBinding
import com.example.callapibyrxjava02.model.MovieItem
import com.example.callapibyrxjava02.utils.ValidationUtil

class MoviesAdapter(var context: Context, var movieList: MutableList<MovieItem>) :
    RecyclerView.Adapter<MoviesAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMoviesBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MainViewHolder, position: Int) {
        var movie = movieList[position]
        if (ValidationUtil.validateMovie(movie)) {
            holder.binding.tvNameMovie.text = movie.name
            holder.binding.tvCategory.text = movie.createdBy
            holder.binding.tvFirstAppearance.text = movie.firstAppearance
            holder.binding.tvPublisher.text = movie.publisher
            holder.binding.tvBio.text = movie.bio
            Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imgMovie)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MainViewHolder(val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}