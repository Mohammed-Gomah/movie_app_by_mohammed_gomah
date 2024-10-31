package com.example.movieapp.fragments.favourite

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

class FavouriteAdapter(
    private var favouriteList: List<Movie>,
    private val onItemClick: (String,Int) -> Unit
) :
    RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {
    inner class FavouriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val favouriteName: TextView = itemView.findViewById(R.id.favourite_name)
        val favouriteImage: ImageView = itemView.findViewById(R.id.favourite_Image)
        val favouriteCard : CardView = itemView.findViewById(R.id.favourite_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.favourite_item, parent, false)
        return FavouriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val favouriteItem = favouriteList[position]
        holder.apply {
            favouriteName.text = favouriteItem.name
            favouriteCard.setOnClickListener {
               onItemClick(favouriteItem.externals?.imdb?:"",favouriteItem.id)
            }
        }

        Glide.with(holder.itemView.context)
            .load(favouriteItem.image?.medium)
            .into(holder.favouriteImage)

    }

    fun setDataToFavourite(newFavouriteList: List<Movie>) {
        favouriteList = newFavouriteList
        notifyDataSetChanged()

    }

}