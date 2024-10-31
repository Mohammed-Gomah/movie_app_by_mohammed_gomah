package com.example.movieapp.fragments.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.Cast
import com.example.movieapp.movieRoom.MovieDatabase
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.launch

class CastViewModel(application: Application) : AndroidViewModel(application) {
    private val movieDao = MovieDatabase.getDatabase(application).movieDao()
    private val repository = MovieRepository(movieDao)
    private val _cast = MutableLiveData<List<Cast>>()
    val cast: LiveData<List<Cast>> = _cast

    fun getCastById(id: Int) {
        try {
            viewModelScope.launch {
                val response = repository.apiService.getCastById(id)
                _cast.postValue(response)
            }
        } catch (e: Exception) {
            Log.e("ApiService", "Error fetching cast data", e)

        }


    }
}