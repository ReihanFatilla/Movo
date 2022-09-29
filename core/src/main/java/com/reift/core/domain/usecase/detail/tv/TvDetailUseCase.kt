package com.reift.core.domain.usecase.detail.tv

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface TvDetailUseCase {
    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>
    fun getTvReviews(id: String): Flowable<Resource<List<Actor>>>
    fun getTvWallpapers(id: String): Flowable<Resource<List<Wallpaper>>>
    fun getTvActors(id: String): Flowable<Resource<List<Actor>>>

    fun isFollowed(id: String): Flow<Boolean?>

    fun deleteFavoriteTv(tv: Tv)
    fun insertFavoriteTv(tv: Tv)
}