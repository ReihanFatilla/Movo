package com.reift.movo.presentation.allmovietv

import android.os.Parcelable
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.usecase.allmovietv.AllMovieTvUseCase
import kotlinx.parcelize.Parcelize

class AllMovieTvViewModel(
    val allMovieTvUseCase: AllMovieTvUseCase
) : ViewModel() {
    val movieResponse = MediatorLiveData<Resource<MovieResult>>()

    val tvResponse = MediatorLiveData<Resource<TvResult>>()

    fun getMoviesByCategory(category: String, page: String = "1"){
        val source = LiveDataReactiveStreams.fromPublisher(
            allMovieTvUseCase.getMovies(category, page)
        )

        movieResponse.addSource(source){
            movieResponse.postValue(it)
            movieResponse.removeSource(source)
        }
    }

    fun getTvByCategory(category: String, page: String = "1"){
        val source = LiveDataReactiveStreams.fromPublisher(
            allMovieTvUseCase.getTvShow(category, page)
        )

        tvResponse.addSource(source){
            tvResponse.postValue(it)
            tvResponse.removeSource(source)
        }
    }
}