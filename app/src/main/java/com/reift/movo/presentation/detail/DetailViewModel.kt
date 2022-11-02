package com.reift.movo.presentation.detail

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.usecase.detail.movie.MovieDetailUseCase

class DetailViewModel(val movieDetailUseCase: MovieDetailUseCase): ViewModel() {

    val detailResponse = MediatorLiveData<Resource<MovieDetail>>()
    val similarResponse = MediatorLiveData<Resource<MovieResult>>()
    val recommendationsResponse = MediatorLiveData<Resource<MovieResult>>()
    val actorResponse = MediatorLiveData<Resource<List<Actor>>>()
    val reviewResponse = MediatorLiveData<Resource<List<Review>>>()
    val wallpaperResponse = MediatorLiveData<Resource<Wallpaper>>()
    val videoResponse = MediatorLiveData<Resource<List<Video>>>()

    fun getMovieDetail(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieDetail(id)
        )

        detailResponse.addSource(source){
            detailResponse.postValue(it)
            detailResponse.removeSource(source)
        }
    }

    fun getMovieActor(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieActors(id)
        )

        actorResponse.addSource(source){
            actorResponse.postValue(it)
            actorResponse.removeSource(source)
        }
    }

    fun getMovieWallpaper(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieWallpapers(id)
        )

        wallpaperResponse.addSource(source){
            wallpaperResponse.postValue(it)
            wallpaperResponse.removeSource(source)
        }
    }

    fun getMovieTrailer(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieVideos(id)
        )

        videoResponse.addSource(source){
            videoResponse.postValue(it)
            videoResponse.removeSource(source)
        }
    }

    fun getMovieReviews(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieReviews(id)
        )

        reviewResponse.addSource(source){
            reviewResponse.postValue(it)
            reviewResponse.removeSource(source)
        }
    }

    fun getRecommendationsMovies(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getRecommendationsMovies(id)
        )

        recommendationsResponse.addSource(source){
            recommendationsResponse.postValue(it)
            recommendationsResponse.removeSource(source)
        }
    }

    fun getSimilarMovies(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getSimilarMovies(id)
        )

        similarResponse.addSource(source){
            similarResponse.postValue(it)
            similarResponse.removeSource(source)
        }
    }

}