package com.example.movieapp.network

import com.example.movieapp.data.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(RetrofitModule.SHOW_END_POINT)
    suspend fun getMovies(): List<Movie>

    @GET(RetrofitModule.SEARCH_END_POINT)
    suspend fun searchMovieByName(@Query("q") query: String): List<Movie>

    @GET(RetrofitModule.DETAILS_END_POINT)
    suspend fun getMovieDetailsById(@Query("imdb") id : String) : Movie

}