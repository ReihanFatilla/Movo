package com.reift.movieapp.presentation.detail

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.Actor
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.core.domain.model.detail.Review
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.usecase.detail.movie.MovieDetailUseCase

class DetailViewModel(val movieDetailUseCase: MovieDetailUseCase): ViewModel() {

    val detailResponse = MediatorLiveData<Resource<MovieDetail>>()
    val similarResponse = MediatorLiveData<Resource<Movie>>()
    val recommendationsResponse = MediatorLiveData<Resource<Movie>>()
    val actorResponse = MediatorLiveData<Resource<Actor>>()
    val reviewResponse = MediatorLiveData<Resource<Review>>()

    fun getMovieDetail(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieDetail(id)
        )

        detailResponse.addSource(source){
            detailResponse.postValue(it)
            detailResponse.removeSource(source)
        }
    }

}