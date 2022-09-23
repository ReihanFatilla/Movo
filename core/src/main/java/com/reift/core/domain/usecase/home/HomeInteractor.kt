package com.reift.core.domain.usecase.home

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeInteractor(
    private val homeRepository: HomeRepository
): HomeUseCase {
    override fun getMovies(category: String): Flowable<Resource<MovieResult>> {
        return homeRepository.getMovies(category)
    }

    override fun getTvShow(category: String): Flowable<Resource<TvResult>> {
        return homeRepository.getTvShow(category)
    }

    override fun saveRegion(region: String) {
        homeRepository.saveRegion(region)
    }
}