package com.reift.core.data.repository

import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.favorite.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl: FavoriteRepository {
    override fun getFavoriteMovies(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteTv(): Flow<List<Tv>> {
        TODO("Not yet implemented")
    }

    override fun isFollowed(): Flow<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

}