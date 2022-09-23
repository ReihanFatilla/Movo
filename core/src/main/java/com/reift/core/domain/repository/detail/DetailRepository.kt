package com.reift.core.domain.repository.detail

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import io.reactivex.rxjava3.core.Flowable

interface DetailRepository {
    fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>>
    fun getMovieReviews(id: String): Flowable<Resource<Review>>
    fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getMovieActors(id: String): Flowable<Resource<Actor>>

    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>
    fun getTvReviews(id: String): Flowable<Resource<Actor>>
    fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getTvActors(id: String): Flowable<Resource<Actor>>
}