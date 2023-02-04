package com.reift.movo.presentation.detail

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.usecase.detail.movie.MovieDetailUseCase
import com.reift.core.domain.usecase.detail.tv.TvDetailUseCase

class DetailViewModel(val movieDetailUseCase: MovieDetailUseCase, val tvDetailUseCase: TvDetailUseCase): ViewModel() {

    val movieDetailResponse = MediatorLiveData<Resource<MovieDetail>>()
    val movieSimilarResponse = MediatorLiveData<Resource<MovieResult>>()
    val movieRecommendationsResponse = MediatorLiveData<Resource<MovieResult>>()

    val tvDetailResponse = MediatorLiveData<Resource<TvDetail>>()
    val tvSimilarResponse = MediatorLiveData<Resource<TvResult>>()
    val tvRecommendationsResponse = MediatorLiveData<Resource<TvResult>>()

    val actorResponse = MediatorLiveData<Resource<List<Actor>>>()
    val reviewResponse = MediatorLiveData<Resource<List<Review>>>()
    val wallpaperResponse = MediatorLiveData<Resource<Wallpaper>>()
    val videoResponse = MediatorLiveData<Resource<List<Video>>>()

    fun getMovieDetail(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieDetail(id)
        )

        movieDetailResponse.addSource(source){
            movieDetailResponse.postValue(it)
            movieDetailResponse.removeSource(source)
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

        movieRecommendationsResponse.addSource(source){
            movieRecommendationsResponse.postValue(it)
            movieRecommendationsResponse.removeSource(source)
        }
    }

    fun getSimilarMovies(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getSimilarMovies(id)
        )

        movieSimilarResponse.addSource(source){
            movieSimilarResponse.postValue(it)
            movieSimilarResponse.removeSource(source)
        }
    }

    fun getTvDetail(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            tvDetailUseCase.getTvDetail(id)
        )

        tvDetailResponse.addSource(source){
            tvDetailResponse.postValue(it)
            tvDetailResponse.removeSource(source)
        }
    }

    fun getTvActor(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieActors(id)
        )

        actorResponse.addSource(source){
            actorResponse.postValue(it)
            actorResponse.removeSource(source)
        }
    }

    fun getTvWallpaper(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieWallpapers(id)
        )

        wallpaperResponse.addSource(source){
            wallpaperResponse.postValue(it)
            wallpaperResponse.removeSource(source)
        }
    }

    fun getTvTrailer(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieVideos(id)
        )

        videoResponse.addSource(source){
            videoResponse.postValue(it)
            videoResponse.removeSource(source)
        }
    }

    fun getTvReviews(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            movieDetailUseCase.getMovieReviews(id)
        )

        reviewResponse.addSource(source){
            reviewResponse.postValue(it)
            reviewResponse.removeSource(source)
        }
    }

    fun getRecommendationsTv(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            tvDetailUseCase.getRecommendationsTv(id)
        )

        tvRecommendationsResponse.addSource(source){
            tvRecommendationsResponse.postValue(it)
            tvRecommendationsResponse.removeSource(source)
        }
    }

    fun getSimilarTv(id: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            tvDetailUseCase.getSimilarTv(id)
        )

        tvSimilarResponse.addSource(source){
            tvSimilarResponse.postValue(it)
            tvSimilarResponse.removeSource(source)
        }
    }

}