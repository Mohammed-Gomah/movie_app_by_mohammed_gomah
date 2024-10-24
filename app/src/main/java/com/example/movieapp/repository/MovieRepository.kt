package com.example.movieapp.repository

import com.example.movieapp.network.ApiService
import com.example.movieapp.network.RetrofitModule

class MovieRepository {

    val apiService:ApiService by lazy {
        RetrofitModule.retrofitClient.create(ApiService::class.java)
    }

}