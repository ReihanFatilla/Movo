package com.reift.core.domain.usecase.search

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.search.SearchRepository
import io.reactivex.rxjava3.core.Flowable

class SearchInteractor(
    private val searchRepository: SearchRepository
): SearchUseCase {
    override fun searchMovie(query: String, page: String): Flowable<Resource<MovieResult>> {
        return searchRepository.searchMovie(query, page)
    }

    override fun searchTvShow(query: String, page: String): Flowable<Resource<TvResult>> {
        return searchRepository.searchTvShow(query, page)
    }
}