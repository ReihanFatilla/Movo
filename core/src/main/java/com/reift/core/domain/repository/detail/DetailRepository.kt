package com.reift.core.domain.repository.detail

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>>
    fun getMovieReviews(id: String): Flowable<Resource<List<Review>>>
    fun getMovieWallpapers(id: String): Flowable<Resource<List<Wallpaper>>>
    fun getMovieActors(id: String): Flowable<Resource<List<Actor>>>

    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>
    fun getTvReviews(id: String): Flowable<Resource<List<Actor>>>
    fun getTvWallpapers(id: String): Flowable<Resource<List<Wallpaper>>>
    fun getTvActors(id: String): Flowable<Resource<List<Actor>>>

    fun isFollowed(id: String): Flow<Boolean?>

    fun insertFavoriteMovie(movie: Movie)
    fun insertFavoriteTv(tv: Tv)

    fun deleteFavoriteMovie(movie: Movie)
    fun deleteFavoriteTv(tv: Tv)
}