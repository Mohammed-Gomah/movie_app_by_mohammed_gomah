package com.example.movieapp.data


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("country")
    val country: Country? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("officialSite")
    val officialSite: String? = null
)