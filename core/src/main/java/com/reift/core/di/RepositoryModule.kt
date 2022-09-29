package com.reift.core.di

import com.reift.core.data.repository.detail.movie.MovieDetailRepositoryImpl
import com.reift.core.data.repository.home.HomeRepositoryImpl
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.domain.repository.home.HomeRepository
import com.reift.core.domain.usecase.detail.movie.MovieDetailInteractor
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    single<MovieDetailRepository> { MovieDetailRepositoryImpl(get(), get()) }
}