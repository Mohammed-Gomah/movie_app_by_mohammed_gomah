package com.example.movieapp.data


data class MovieResponse(
    val score: Double,
    val show: Movie
)

data class Movie(
    val id: Int?,
    val name: String?,
    val language: String?,
    val genres: List<String>?,
    val status: String?,
    val runtime: Int?,
    val premiered: String?,
    val ended: String?,
    val officialSite: String?,
    val schedule: Schedule?,
    val rating: Rating?,
    val weight: Int?,
    val network: Network?,
    val webChannel: WebChannel?,
    val externals: Externals?,
    val image: Image?,
    val summary: String?
)

data class Schedule(
    val time: String?,
    val days: List<String>?
)

data class Rating(
    val average: Double?
)

data class Network(
    val id: Int?,
    val name: String?,
    val country: Country?
)

data class WebChannel(
    val id: Int?,
    val name: String?,
    val country: Country?
)

data class Country(
    val name: String?,
    val code: String?,
    val timezone: String?
)

data class Externals(
    val tvrage: Int?,
    val thetvdb: Int?,
    val imdb: String?
)

data class Image(
    val medium: String?,
    val original: String?
)