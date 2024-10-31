package com.example.movieapp.fragments.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.movieapp.data.Movie
import com.example.movieapp.movieRoom.MovieDatabase
import com.example.movieapp.repository.MovieRepository

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {
    private val movieDao = MovieDatabase.getDatabase(application).movieDao()
    private val repository = MovieRepository(movieDao)
    val readAllData: LiveData<List<Movie>> = repository.readAllData()
}