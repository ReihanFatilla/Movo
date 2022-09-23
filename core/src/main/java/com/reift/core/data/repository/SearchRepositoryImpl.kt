package com.reift.core.data.repository

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.search.SearchRepository
import io.reactivex.rxjava3.core.Flowable

class SearchRepositoryImpl: SearchRepository {
    override fun searchMovie(query: String, page: String): Flowable<Resource<MovieResult>> {
        TODO("Not yet implemented")
    }

    override fun searchTvShow(query: String, page: String): Flowable<Resource<TvResult>> {
        TODO("Not yet implemented")
    }

}