package com.example.movieapp.fragments.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.movieRoom.MovieDatabase
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    private val dataDao = MovieDatabase.getDatabase(application).movieDao()
    private val repository = MovieRepository(dataDao)
    private var _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movie

    fun searchMovieByName(name: String) {
        viewModelScope.launch {
            try {
                val response = repository.apiService.searchMovieByName(name)
                val movies = response.map { movie->movie.show }
                _movie.postValue(movies)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}