package com.reift.core.domain.usecase.detail

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface DetailUseCase {
    fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>>
    fun getMovieReviews(id: String): Flowable<Resource<Review>>
    fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getMovieActors(id: String): Flowable<Resource<Actor>>

    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>
    fun getTvReviews(id: String): Flowable<Resource<Actor>>
    fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getTvActors(id: String): Flowable<Resource<Actor>>

    fun isFollowed(id: String): Flow<Boolean?>

    fun insertFavoriteMovie(movie: Movie)
    fun insertFavoriteTv(tv: Tv)

    fun deleteFavoriteMovie(movie: Movie)
    fun deleteFavoriteTv(tv: Tv)
}