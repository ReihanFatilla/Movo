package com.reift.movo.di

import com.reift.core.domain.usecase.detail.movie.MovieDetailInteractor
import com.reift.core.domain.usecase.detail.movie.MovieDetailUseCase
import com.reift.core.domain.usecase.home.HomeInteractor
import com.reift.core.domain.usecase.home.HomeUseCase
import com.reift.movo.presentation.detail.DetailViewModel
import com.reift.movo.presentation.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeUseCase> { HomeInteractor(get()) }
    single<MovieDetailUseCase> { MovieDetailInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}