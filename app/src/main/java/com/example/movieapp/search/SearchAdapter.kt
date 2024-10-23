package com.example.movieapp.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie

class SearchAdapter(private var movieList: List<Movie>) :
    RecyclerView.Adapter<SearchAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val searchImage: ImageView = itemView.findViewById(R.id.searchImageItem)
        val searchMovie: TextView = itemView.findViewById(R.id.searchItemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.searchMovie.text = movie.name
        Glide.with(holder.itemView.context)
            .load(movie.image?.medium)
            .into(holder.searchImage)
    }
  fun filterList(filteredList:List<Movie>){
        movieList = filteredList
        notifyDataSetChanged()
    }
}