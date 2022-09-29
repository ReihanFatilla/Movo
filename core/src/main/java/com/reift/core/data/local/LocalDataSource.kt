package com.reift.core.data.local

import com.reift.core.data.local.source.room.movie.MovieDao
import com.reift.core.data.local.source.room.movie.MovieEntity
import com.reift.core.data.local.source.room.tv.TvDao
import com.reift.core.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) {

    fun getFavoriteMovie(): Flow<List<MovieEntity>>{
        return movieDao.getFavoriteMovie()
    }

    fun getFavoriteById(id: String): Flow<MovieEntity>{
        return movieDao.getFavoriteById(id)
    }

    suspend fun insertFavoriteMovie(movie: MovieEntity){
        movieDao.insertFavoriteMovie(movie)
    }

    suspend fun deleteFavoriteMovie(movie: MovieEntity){
        movieDao.deleteFavoriteMovie(movie)
    }
}