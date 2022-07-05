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
    var trendingResponse = MutableLiveData<MovieResponse>()
    var upcomingResponse = MutableLiveData<MovieResponse>()

    fun getNowPlayingMovie(
        region: String,
        page: String
    ){
        repository.getMovieList(
            {
                nowPlayingResponse.value = it
            },{},
            Constant.NOW_PLAYING,
            region,
            page
        )
    }

    fun getUpcomingMovie(
        region: String,
        page: String
    ){
        repository.getMovieList(
            {
                upcomingResponse.value = it
            },{},
            Constant.UPCOMING,
            region,
            page
        )
    }

    fun getAiringTodayTvShow(
        region: String,
        page: String
    ){
        repository.getTVShowList(
            {
                nowPlayingResponse.value = it
            },{},
            Constant.AIRING_TODAY,
            region,
            page
        )
    }

    fun getTrendingList(
        media: String,
        region: String,
        page: String
    ){
        repository.getTrendingList(
            {
                trendingResponse.value = it
            },{},
            media,
            region,
            page
        )
    }

}