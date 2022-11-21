package com.reift.core.data.repository.search

import com.reift.core.data.NetworkResource
import com.reift.core.data.remote.RemoteDataSource
import com.reift.core.data.remote.source.response.movie.MovieResponse
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.search.SearchRepository
import com.reift.core.mapper.HomeMapper.map
import io.reactivex.rxjava3.core.Flowable

class SearchRepositoryImpl(
    val remoteDataSource: RemoteDataSource
): SearchRepository {
    override fun searchMovie(query: String, page: String): Flowable<Resource<MovieResult>> {
        return object: NetworkResource<MovieResult, MovieResponse>(){
            override fun createResult(data: MovieResponse): MovieResult {
                return data.map()
            }

            override fun createCall(): Flowable<MovieResponse> {
                return remoteDataSource.searchMovieByQuery(query, page)
            }

        }.asFlowable()
    }

    override fun searchTvShow(query: String, page: String): Flowable<Resource<TvResult>> {
        TODO("Not yet implemented")
    }

}