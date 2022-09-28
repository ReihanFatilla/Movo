package com.reift.movieapp.presentation.home

import android.app.Application
import android.arch.lifecycle.ViewModel
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.reift.core.constant.Constant
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.usecase.home.HomeUseCase

class HomeViewModel(val homeUseCase: HomeUseCase): ViewModel() {

    var nowPlayingResponse = MediatorLiveData<Resource<MovieResult>>()

    var currentPage = MutableLiveData(1)

    fun getNowPlayingMovie(){
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.getMovies(Constant.NOW_PLAYING, currentPage.value.toString())
        )

        nowPlayingResponse.addSource(source){
            nowPlayingResponse.postValue(it)
            nowPlayingResponse.removeSource(source)
        }
    }


//    private val repository: MovieRepository = MovieRepository(application)
//

//    var trendingResponse = MutableLiveData<MovieResponse>()
//    var topRatedResponse = MutableLiveData<MovieResponse>()
//    var popularResponse = MutableLiveData<MovieResponse>()
//    var upcomingResponse = MutableLiveData<MovieResponse>()
//
//    var isLoading = MutableLiveData<Boolean>()
//
//    fun getListByType(
//        media: String,
//        type: String,
//        region: String,
//        page: String,
//    ){
//        repository.getMovieTVList(
//            {
//                when (type) {
//                    Constant.NOW_PLAYING -> nowPlayingResponse.value = it
//                    Constant.TOP_RATED -> topRatedResponse.value = it
//                    Constant.POPULAR_MOVIE -> popularResponse.value = it
//                    Constant.UPCOMING -> upcomingResponse.value = it
//                }
//            },{},
//            media,
//            type,
//            region,
//            page
//        )
//    }
//
//    fun getAiringTodayTvShow(
//        region: String,
//        page: String
//    ){
//        repository.getMovieTVList(
//            {
//                nowPlayingResponse.value = it
//            },{},
//            Constant.MEDIA_TV,
//            Constant.AIRING_TODAY,
//            region,
//            page
//        )
//    }
//
//    fun getTrendingList(
//        media: String,
//        region: String,
//        page: String
//    ){
//        repository.getTrendingList(
//            {
//                trendingResponse.value = it
//            },{},
//            media,
//            region,
//            page
//        )
//    }
//
//    fun getNowPlayingMovie(
//        region: String,
//        page: String
//    ) {
//        repository.getMovieTVList(
//            {
//                nowPlayingResponse.value = it
//                isLoading.value = true
//            },{},
//            Constant.MEDIA_MOVIE,
//            Constant.NOW_PLAYING,
//            region,
//            page
//        )
//    }

}