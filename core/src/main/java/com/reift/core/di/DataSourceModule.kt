package com.reift.core.di

import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    factory { RemoteDataSource(get()) }
    factory { LocalDataSource(get(), get()) }
}