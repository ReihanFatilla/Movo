package com.reift.core.domain.repository.search

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable

interface SearchRepository {
    fun searchMovie(query: String, page: String): Flowable<Resource<MovieResult>>
    fun searchTvShow(query: String, page: String): Flowable<Resource<TvResult>>
}