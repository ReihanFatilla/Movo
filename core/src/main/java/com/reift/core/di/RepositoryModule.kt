package com.reift.core.di

import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.repository.HomeRepositoryImpl
import com.reift.core.domain.repository.home.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}