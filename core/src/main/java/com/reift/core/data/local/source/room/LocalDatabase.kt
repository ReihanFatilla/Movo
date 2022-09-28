package com.reift.core.data.local.source.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reift.core.data.local.source.room.movie.MovieDao
import com.reift.core.data.local.source.room.movie.MovieEntity
import com.reift.core.data.local.source.room.tv.TvDao
import com.reift.core.data.local.source.room.tv.TvEntity

@Database(entities = [MovieEntity::class, TvEntity::class], version = 1)
abstract class LocalDatabase: RoomDatabase(){
    abstract val movieDao: MovieDao
    abstract val tvDao: TvDao
}
