package com.example.movieapp.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.data.MovieRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = MovieRepository()
    private var _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movie

    fun searchMovieByName(name: String) {
        viewModelScope.launch {
            try {
                val response = repository.apiService.searchMovieByName(name)
                _movie.postValue(response)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}