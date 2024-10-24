package com.example.movieapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = MovieRepository()

    private val _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movie

    fun getMovie() {
        viewModelScope.launch {
            try {
                val response = repository.apiService.getMovies()
                _movie.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}