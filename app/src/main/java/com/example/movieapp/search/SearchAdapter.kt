package com.example.movieapp.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie

class SearchAdapter(
    private var movieList: List<Movie>,
    val onItemClick: (String) -> Unit
) :
    RecyclerView.Adapter<SearchAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val searchImage: ImageView = itemView.findViewById(R.id.searchImageItem)
        val searchMovie: TextView = itemView.findViewById(R.id.searchItemName)
        val searchCard: CardView = itemView.findViewById(R.id.searchCard)
        val movieRating : TextView = itemView.findViewById(R.id.itemRate)
        val movieStartDate : TextView = itemView.findViewById(R.id.startDate)
        val movieEndDate : TextView = itemView.findViewById(R.id.endDate)
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
        holder.searchMovie.text = movie.name ?: "No Name"
        holder.movieRating.text = movie.rating?.average.toString()
        holder.movieStartDate.text = movie.premiered
        holder.movieEndDate.text = movie.ended
        holder.searchCard.setOnClickListener {
            onItemClick(movie.externals?.imdb ?: "")
        }
        Glide.with(holder.itemView.context)
            .load(movie.image?.medium)
            .error(R.drawable.image_placeholder)
            .into(holder.searchImage)
    }

    fun filterList(filteredList: List<Movie>) {
        movieList = filteredList
        notifyDataSetChanged()
    }
}