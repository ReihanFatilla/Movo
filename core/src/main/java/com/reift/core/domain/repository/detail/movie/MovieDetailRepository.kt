package com.reift.core.domain.repository.detail.movie

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.Tv
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>>
    fun getMovieReviews(id: String): Flowable<Resource<List<Review>>>
    fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getMovieActors(id: String): Flowable<Resource<List<Actor>>>
    fun getMovieVideos(id: String): Flowable<Resource<List<Video>>>

    fun isFollowed(id: String): Flow<Boolean>

    fun insertFavoriteMovie(movie: Movie)
    fun deleteFavoriteMovie(movie: Movie)

    fun getRecommendationsMovies(id: String): Flowable<Resource<MovieResult>>
    fun getSimilarMovies(id: String): Flowable<Resource<MovieResult>>
}