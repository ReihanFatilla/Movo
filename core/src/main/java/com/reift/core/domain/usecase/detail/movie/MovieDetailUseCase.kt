package com.reift.core.domain.usecase.detail.movie

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface MovieDetailUseCase {
    fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>>
    fun getMovieReviews(id: String): Flowable<Resource<List<Review>>>
    fun getMovieWallpapers(id: String): Flowable<Resource<List<Wallpaper>>>
    fun getMovieActors(id: String): Flowable<Resource<List<Actor>>>

    fun insertFavoriteMovie(movie: Movie)

    fun deleteFavoriteMovie(movie: Movie)

}