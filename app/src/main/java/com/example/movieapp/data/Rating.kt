package com.example.movieapp.data


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double? = null
)