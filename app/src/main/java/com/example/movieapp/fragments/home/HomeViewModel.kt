package com.example.movieapp.fragments.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.movieRoom.MovieDatabase
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.launch


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val movieDao = MovieDatabase.getDatabase(application).movieDao()
    private val repository = MovieRepository(movieDao)

    private val _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movie
    fun getMovie() {
        viewModelScope.launch {
            try {
                val response = repository.apiService.getMovies()
                _movie.postValue(response.shuffled())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}