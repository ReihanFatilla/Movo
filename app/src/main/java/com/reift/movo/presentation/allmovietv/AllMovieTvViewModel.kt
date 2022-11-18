package com.reift.movo.presentation.allmovietv

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.usecase.allmovietv.AllMovieTvUseCase

class AllMovieTvViewModel(
    val allMovieTvUseCase: AllMovieTvUseCase
) : ViewModel() {
    val movieResponse = MediatorLiveData<Resource<MovieResult>>()

    fun getMoviesByCategory(category: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            allMovieTvUseCase.getMovies(category, "1")
        )

        movieResponse.addSource(source){
            movieResponse.postValue(it)
            movieResponse.removeSource(source)
        }
    }
}