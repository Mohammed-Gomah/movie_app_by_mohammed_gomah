package com.example.movieapp.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = MovieRepository()
    private var _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movie

    fun searchMovieByName(name: String) {
        viewModelScope.launch {
            Log.d("SearchViewModel", "Searching for: $name")
            try {
                val response = repository.apiService.searchMovieByName(name)
                val movies = response.map { it.show }
                _movie.postValue(movies)
            }catch (e:Exception){
                Log.e("SearchViewModel", "Error: ${e.message}")
            }
        }
    }
}