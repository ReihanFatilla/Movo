package com.reift.movieapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1)
abstract class FavoriteDB: RoomDatabase(){
    abstract val favoriteDao: FavoriteDao

    companion object{
        @Volatile
        var instace: FavoriteDB? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instace ?: synchronized(LOCK) {
            instace ?: buildDataBase(context).also {
                instace = it
            }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context, FavoriteDB::class.java, "favorite.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
