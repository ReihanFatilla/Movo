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
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.presentation.home.component.MovieTypeData

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MovieRepository = MovieRepository(application)

    var nowPlayingResponse = MutableLiveData<MovieResponse>()
    var trendingResponse = MutableLiveData<MovieResponse>()
    var topRatedResponse = MutableLiveData<MovieResponse>()
    var popularResponse = MutableLiveData<MovieResponse>()
    var upcomingResponse = MutableLiveData<MovieResponse>()

    var isLoading = MutableLiveData<Boolean>()

    fun getListByType(
        media: String,
        type: String,
        region: String,
        page: String,
    ){
        repository.getMovieTVList(
            {
                when (type) {
                    Constant.NOW_PLAYING -> nowPlayingResponse.value = it
                    Constant.TOP_RATED -> topRatedResponse.value = it
                    Constant.POPULAR_MOVIE -> popularResponse.value = it
                    Constant.UPCOMING -> upcomingResponse.value = it
                }
            },{},
            media,
            type,
            region,
            page
        )
    }

    fun getAiringTodayTvShow(
        region: String,
        page: String
    ){
        repository.getMovieTVList(
            {
                nowPlayingResponse.value = it
            },{},
            Constant.MEDIA_TV,
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

    fun getNowPlayingMovie(
        region: String,
        page: String
    ) {
        repository.getMovieTVList(
            {
                nowPlayingResponse.value = it
                isLoading.value = true
            },{},
            Constant.MEDIA_MOVIE,
            Constant.NOW_PLAYING,
            region,
            page
        )
    }

}