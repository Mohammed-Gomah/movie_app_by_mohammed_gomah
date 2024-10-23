package com.example.movieapp.data


import com.google.gson.annotations.SerializedName

data class Previousepisode(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null
)