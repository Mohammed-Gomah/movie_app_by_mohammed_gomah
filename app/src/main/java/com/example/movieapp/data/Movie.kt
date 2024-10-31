package com.example.movieapp.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val show: Movie
)

@Entity(tableName = "movie_table")
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
    @PrimaryKey @SerializedName("id") val id: Int,
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
    val weight: Int? = null,
)

data class Links(
    @SerializedName("previousepisode")
    val previousepisode: Previousepisode? = null,
    @SerializedName("self")
    val self: Self? = null
)

data class Image(
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("original")
    val original: String? = null
)

data class Externals(
    @SerializedName("imdb")
    val imdb: String? = null,
    @SerializedName("thetvdb")
    val thetvdb: Int? = null,
    @SerializedName("tvrage")
    val tvrage: Int? = null
)

data class Country(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("timezone")
    val timezone: String? = null
)

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

data class Previousepisode(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class Rating(
    @SerializedName("average")
    val average: Double? = null
)
data class Schedule(
    @SerializedName("days")
    val days: List<String?>? = null,
    @SerializedName("time")
    val time: String? = null
)

data class Self(
    @SerializedName("href")
    val href: String? = null
)