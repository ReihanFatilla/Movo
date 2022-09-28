package com.reift.movieapp.di

import com.reift.core.domain.usecase.detail.DetailInteractor
import com.reift.core.domain.usecase.detail.DetailUseCase
import com.reift.core.domain.usecase.home.HomeInteractor
import com.reift.core.domain.usecase.home.HomeUseCase
import com.reift.core.domain.usecase.search.SearchInteractor
import com.reift.core.domain.usecase.search.SearchUseCase
import com.reift.movieapp.presentation.detail.DetailViewModel
import com.reift.movieapp.presentation.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeUseCase> { HomeInteractor(get()) }
    single<DetailUseCase> { DetailInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}