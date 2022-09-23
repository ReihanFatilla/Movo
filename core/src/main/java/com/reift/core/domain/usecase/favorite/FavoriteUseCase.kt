package com.reift.core.domain.usecase.favorite

import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun getFavoriteTv(): Flow<List<Tv>>

    fun isFollowed(): Flow<Boolean?>

    fun insertFavoriteMovie(movie: Movie)
    fun insertFavoriteTv(tv: Tv)
}