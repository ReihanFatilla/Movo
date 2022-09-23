package com.reift.core.domain.usecase.detail

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import io.reactivex.rxjava3.core.Flowable

interface DetailUseCase {
    fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>>
    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>

    fun getReviews(id: String): Flowable<Resource<Review>>
    fun getWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getActors(id: String): Flowable<Resource<Actor>>
}