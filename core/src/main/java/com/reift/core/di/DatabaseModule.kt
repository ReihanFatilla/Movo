package com.reift.core.di

import android.content.Context
import androidx.room.Room
import com.reift.core.data.local.source.room.LocalDatabase
import com.reift.core.data.local.source.room.movie.MovieDao
import com.reift.core.data.local.source.room.tv.TvDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): LocalDatabase = Room.databaseBuilder(
        context,
        LocalDatabase::class.java, "favorite.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: LocalDatabase): MovieDao = database.movieDao

    @Provides
    fun provideTvDao(database: LocalDatabase): TvDao = database.tvDao

}