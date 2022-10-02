package com.reift.core.di

import com.reift.movo.di.useCaseModule
import com.reift.movo.di.viewModelModule

val listModules = listOf(
    databaseModule,
    networkModule,
    repositoryModule,
    dataSourceModule,
    useCaseModule,
    viewModelModule
)