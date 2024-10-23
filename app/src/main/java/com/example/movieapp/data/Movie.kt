package com.example.movieapp.data


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("averageRuntime")
    val averageRuntime: Int? = null,
    @SerializedName("dvdCountry")
    val dvdCountry: Any? = null,
    @SerializedName("ended")
    val ended: String? = null,
    @SerializedName("externals")
    val externals: Externals? = null,
    @SerializedName("genres")
    val genres: List<String?>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("_links")
    val links: Links? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("network")
    val network: Network? = null,
    @SerializedName("officialSite")
    val officialSite: String? = null,
    @SerializedName("premiered")
    val premiered: String? = null,
    @SerializedName("rating")
    val rating: Rating? = null,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("schedule")
    val schedule: Schedule? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("updated")
    val updated: Int? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("webChannel")
    val webChannel: Any? = null,
    @SerializedName("weight")
    val weight: Int? = null
)