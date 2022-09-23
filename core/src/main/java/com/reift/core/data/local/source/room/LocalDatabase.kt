package com.reift.core.data.local.source.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reift.core.data.local.source.room.movie.MovieDao
import com.reift.core.data.local.source.room.movie.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class LocalDatabase: RoomDatabase(){
    abstract val movieDao: MovieDao

    companion object{
        @Volatile
        var instace: LocalDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instace ?: synchronized(LOCK) {
            instace ?: buildDataBase(context).also {
                instace = it
            }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context, LocalDatabase::class.java, "favorite.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
