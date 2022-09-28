package com.reift.core.di

import com.reift.core.data.repository.HomeRepositoryImpl
import com.reift.core.domain.repository.allmovietv.AllMovieTvRepository
import com.reift.core.domain.repository.home.HomeRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}