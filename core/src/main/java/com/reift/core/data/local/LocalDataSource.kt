package com.reift.core.data.local

import com.reift.core.data.local.source.room.movie.MovieDao
import com.reift.core.data.local.source.room.tv.TvDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) {
}