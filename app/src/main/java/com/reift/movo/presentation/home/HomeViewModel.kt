package com.reift.movo.presentation.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.usecase.home.HomeUseCase

class HomeViewModel(val homeUseCase: HomeUseCase): ViewModel() {

    var nowPlayingResponse = MediatorLiveData<Resource<MovieResult>>()
    var popularResponse = MediatorLiveData<Resource<MovieResult>>()
    var upcomingResponse = MediatorLiveData<Resource<MovieResult>>()

    var currentPage = MutableLiveData(1)

    fun getNowPlayingMovies(){
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.getMovies(Constant.NOW_PLAYING_MOVIE, currentPage.value.toString())
        )

        nowPlayingResponse.addSource(source){
            nowPlayingResponse.postValue(it)
            nowPlayingResponse.removeSource(source)
        }
    }

    fun getPopularMovies(){
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.getMovies(Constant.POPULAR_MOVIE, currentPage.value.toString())
        )

        popularResponse.addSource(source){
            popularResponse.postValue(it)
            popularResponse.removeSource(source)
        }
    }

    fun getUpComingMovies(){
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.getMovies(Constant.UPCOMING_MOVIE, currentPage.value.toString())
        )

        upcomingResponse.addSource(source){
            upcomingResponse.postValue(it)
            upcomingResponse.removeSource(source)
        }
    }

}