package com.example.movieapp.fragments.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.movieRoom.MovieDatabase
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val movieDao = MovieDatabase.getDatabase(application).movieDao()
    private val repository = MovieRepository(movieDao)

    private var _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private var _isFavourite = MutableLiveData<Boolean>()
    val isFavourite: LiveData<Boolean> = _isFavourite

    fun getMovieDetailsById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.apiService.getMovieDetailsById(id)
                _movie.postValue(response)
                checkFavourite(response.id)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun insertMovie() {
        try {
            viewModelScope.launch {
                repository.insertMovie(_movie.value!!)
                _isFavourite.postValue(true)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun deleteMovie() {
        try {
            viewModelScope.launch {
                repository.deleteMovieById(_movie.value?.id!!)
                _isFavourite.postValue(false)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    private fun checkFavourite(movieId: Int) {
        try {
            viewModelScope.launch {
                val movie = repository.getMovieById(movieId)
                _isFavourite.postValue(movie!=null)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

    }



}