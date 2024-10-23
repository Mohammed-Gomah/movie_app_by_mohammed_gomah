package com.example.movieapp.data


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("previousepisode")
    val previousepisode: Previousepisode? = null,
    @SerializedName("self")
    val self: Self? = null
)