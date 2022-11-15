package com.reift.movo.presentation.home.fragment

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.usecase.home.HomeUseCase

class HomeTabViewModel(
    val homeUseCase: HomeUseCase
) : ViewModel() {
    val movieResponse = MediatorLiveData<Resource<MovieResult>>()

    fun getMoviesByCategory(category: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.getMovies(category, "1")
        )

        movieResponse.addSource(source){
            movieResponse.postValue(it)
            movieResponse.removeSource(source)
        }
    }
}