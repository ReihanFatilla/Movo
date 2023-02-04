package com.reift.movo.di

import com.reift.core.domain.usecase.allmovietv.AllMovieTvInteractor
import com.reift.core.domain.usecase.allmovietv.AllMovieTvUseCase
import com.reift.core.domain.usecase.detail.movie.MovieDetailInteractor
import com.reift.core.domain.usecase.detail.movie.MovieDetailUseCase
import com.reift.core.domain.usecase.home.HomeInteractor
import com.reift.core.domain.usecase.home.HomeUseCase
import com.reift.core.domain.usecase.search.SearchInteractor
import com.reift.core.domain.usecase.search.SearchUseCase
import com.reift.movo.presentation.allmovietv.AllMovieTvViewModel
import com.reift.movo.presentation.detail.DetailViewModel
import com.reift.movo.presentation.home.HomeViewModel
import com.reift.movo.presentation.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeUseCase> { HomeInteractor(get()) }
    single<AllMovieTvUseCase> { AllMovieTvInteractor(get()) }
    single<MovieDetailUseCase> { MovieDetailInteractor(get()) }
    single<SearchUseCase> { SearchInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { AllMovieTvViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}