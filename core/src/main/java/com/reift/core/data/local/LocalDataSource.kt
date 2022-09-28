package com.reift.core.data.local

import com.reift.core.data.local.source.room.movie.MovieDao
import com.reift.core.data.local.source.room.tv.TvDao

class LocalDataSource(
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) {
}