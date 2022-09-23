package com.reift.core.domain.usecase.allmovietv

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.allmovietv.AllMovieTvRepository
import io.reactivex.rxjava3.core.Flowable

class AllMovieTvInteractor(
    private val allMovieTvRepository: AllMovieTvRepository
): AllMovieTvUseCase {
    override fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>> {
        return allMovieTvRepository.getMovies(category, page)
    }

    override fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>> {
        return allMovieTvRepository.getTvShow(category, page)
    }
}