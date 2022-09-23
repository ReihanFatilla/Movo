package com.reift.core.data.repository

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeRepositoryImpl: HomeRepository {
    override fun getMovies(category: String): Flowable<Resource<MovieResult>> {
        TODO("Not yet implemented")
    }

    override fun getTvShow(category: String): Flowable<Resource<TvResult>> {
        TODO("Not yet implemented")
    }

    override fun saveRegion(region: String) {
        TODO("Not yet implemented")
    }
}