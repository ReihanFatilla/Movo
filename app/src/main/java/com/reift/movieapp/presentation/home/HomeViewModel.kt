package com.reift.movieapp.presentation.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.MovieRepository
import com.reift.movieapp.data.MovieResponse

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val repository: MovieRepository = MovieRepository(application)

    var nowPlayingResponse = MutableLiveData<MovieResponse>()

    fun getNowPlayingMovie(
        type: String,
        region: String,
        page: String
    ){
        repository.getMovieList(
            {
                nowPlayingResponse.value = it
            },{},
            type,
            region,
            page
        )
    }

    fun getAiringTodayTvShow(
        type: String,
        region: String,
        page: String
    ){
        repository.getTVShowList(
            {
                nowPlayingResponse.value = it
            },{},
            type,
            region,
            page
        )
    }

}