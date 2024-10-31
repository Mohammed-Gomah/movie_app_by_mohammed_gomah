package com.example.movieapp.fragments.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Cast

class CastAdapter(private var actorList: List<Cast>) :
    RecyclerView.Adapter<CastAdapter.ActorViewHolder>() {
    inner class ActorViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val actorName :TextView = itemView.findViewById(R.id.actorName)
        val actorImage : ImageView = itemView.findViewById(R.id.actorImage)
        val characterName : TextView = itemView.findViewById(R.id.characterName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_item,parent,false)
        return ActorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = actorList[position]
        holder.actorName.text = actor.person?.name
        holder.characterName.text=actor.character?.name
        Glide.with(holder.itemView.context)
            .load(actor.character?.image?.medium)
            .into(holder.actorImage)
    }

    fun setCast(newActorsList: List<Cast>) {
        actorList = newActorsList
        notifyDataSetChanged()
    }


}