package com.example.movieapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.movieapp.data.Movie
import com.example.movieapp.movieRoom.MovieDao
import com.example.movieapp.network.ApiService
import com.example.movieapp.network.RetrofitModule

class MovieRepository(private val movieDao: MovieDao) {

    val apiService:ApiService by lazy {
        RetrofitModule.retrofitClient.create(ApiService::class.java)
    }

    fun readAllData () : LiveData<List<Movie>>{
        return movieDao.readAllData()
    }

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovieById(movieId: Int) {
        Log.d("DeleteMovie", "Deleting movie with ID: $movieId") // تأكد من وصول المعرف بشكل صحيح
        movieDao.deleteMovieById(movieId)
    }

    suspend fun getMovieById(movieId: Int): Movie? {
        return movieDao.getMovieById(movieId)
    }

}