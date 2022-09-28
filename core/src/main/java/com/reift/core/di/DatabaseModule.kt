package com.reift.core.di

import androidx.room.Room
import com.reift.core.data.local.source.room.LocalDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            LocalDatabase::class.java, "favorite.db"
        ).fallbackToDestructiveMigration().build()
    }

    factory { get<LocalDatabase>().tvDao }
    factory { get<LocalDatabase>().movieDao }
}