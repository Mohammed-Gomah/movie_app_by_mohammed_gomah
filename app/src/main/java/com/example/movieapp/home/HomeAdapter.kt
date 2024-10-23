package com.example.movieapp.home

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

class HomeAdapter(
    private var movieList: List<Movie>,
    private val onItemClick: (String) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieName: TextView = itemView.findViewById(R.id.movie_name)
        val movieImage: ImageView = itemView.findViewById(R.id.movie_Image)
        val homeCard: CardView = itemView.findViewById(R.id.home_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.movieName.text = movie.name
        holder.homeCard.setOnClickListener {
            onItemClick(movie.externals?.imdb ?: "")
        }
        Glide.with(holder.itemView.context)
            .load(movie.image?.original)
            .into(holder.movieImage)
    }


    fun setMovies(newMovieList: List<Movie>) {
        movieList = newMovieList
        notifyDataSetChanged()
    }
}