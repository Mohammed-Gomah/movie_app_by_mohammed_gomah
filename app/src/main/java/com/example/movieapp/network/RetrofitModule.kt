package com.example.movieapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private const val BASE_URL = "https://api.tvmaze.com/"
    const val SHOW_END_POINT = "shows"
    const val SEARCH_END_POINT = "search/shows"
    const val DETAILS_END_POINT = "lookup/shows"

    val retrofitClient : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}