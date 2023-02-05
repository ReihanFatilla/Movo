package com.reift.core.di

import com.reift.core.data.repository.allmovie.AllMovieTvRepositoryImpl
import com.reift.core.data.repository.detail.movie.MovieDetailRepositoryImpl
import com.reift.core.data.repository.detail.tv.TvDetailRepositoryImpl
import com.reift.core.data.repository.home.HomeRepositoryImpl
import com.reift.core.data.repository.search.SearchRepositoryImpl
import com.reift.core.domain.repository.allmovietv.AllMovieTvRepository
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.domain.repository.detail.tv.TvDetailRepository
import com.reift.core.domain.repository.home.HomeRepository
import com.reift.core.domain.repository.search.SearchRepository
import com.reift.core.domain.usecase.allmovietv.AllMovieTvUseCase
import com.reift.core.domain.usecase.detail.movie.MovieDetailInteractor
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    single<MovieDetailRepository> { MovieDetailRepositoryImpl(get(), get()) }
    single<TvDetailRepository> { TvDetailRepositoryImpl(get(), get()) }
    single<AllMovieTvRepository> { AllMovieTvRepositoryImpl(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get()) }
}