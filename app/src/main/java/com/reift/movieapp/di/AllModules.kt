package com.reift.core.di

import com.reift.movieapp.di.useCaseModule
import com.reift.movieapp.di.viewModelModule

val listModules = listOf(
    databaseModule,
    networkModule,
    repositoryModule,
    dataSourceModule,
    useCaseModule,
    viewModelModule
)