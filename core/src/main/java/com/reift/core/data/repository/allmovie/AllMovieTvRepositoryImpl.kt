package com.reift.core.data.repository.allmovie

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.allmovietv.AllMovieTvRepository
import io.reactivex.rxjava3.core.Flowable

class AllMovieTvRepositoryImpl: AllMovieTvRepository {
    override fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>> {
        TODO("Not yet implemented")
    }

    override fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>> {
        TODO("Not yet implemented")
    }

}