package com.reift.core.domain.repository.home

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable

interface HomeRepository {
    fun getMovies(category: String): Flowable<Resource<MovieResult>>
    fun getTvShow(category: String): Flowable<Resource<TvResult>>
    fun saveRegion(region: String)
}