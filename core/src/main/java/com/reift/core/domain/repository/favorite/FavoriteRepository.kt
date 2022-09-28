package com.reift.core.domain.repository.favorite

import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun getFavoriteTv(): Flow<List<Tv>>


}