package com.reift.core.data.repository

import com.reift.core.data.NetworkResource
import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.remote.RemoteDataSource
import com.reift.core.data.remote.source.response.movie.MovieResponse
import com.reift.core.data.remote.source.response.tv.TvResponse
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.home.HomeRepository
import com.reift.core.mapper.HomeMapper.map
import io.reactivex.rxjava3.core.Flowable

class HomeRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
): HomeRepository {
    override fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>> {
        return object : NetworkResource<MovieResult, MovieResponse>() {
            override fun createResult(data: MovieResponse): MovieResult {
                return data.map()
            }

            override fun createCall(): Flowable<MovieResponse> {
                return remoteDataSource.getMoviesByCategory(category, page)
            }

        }.asFlowable()
    }

    override fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>> {
        return object : NetworkResource<TvResult, TvResponse>() {
            override fun createResult(data: TvResponse): TvResult {
                return data.map()
            }

            override fun createCall(): Flowable<TvResponse> {
                return remoteDataSource.getTvByCategory(category, page)
            }

        }.asFlowable()
    }

    override fun saveRegion(region: String) {
        TODO("Not yet implemented")
    }
}