package com.example.movieapp.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Movie
import com.example.movieapp.data.MovieRepository
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {
    private val repository = MovieRepository()
    private var _movie = MutableLiveData<Movie>()
    val movie : LiveData<Movie> = _movie

    fun getMovieById(id:String){
        viewModelScope.launch {
            try {
                val response = repository.apiService.getMovieDetailsById(id)
                _movie.postValue(response)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}