package com.reift.core.domain.usecase.detail.tv

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface TvDetailUseCase {
    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>
    fun getTvReviews(id: String): Flowable<Resource<List<Review>>>
    fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getTvActors(id: String): Flowable<Resource<List<Actor>>>
    fun getTvVideos(id: String): Flowable<Resource<List<Video>>>

    fun isFollowed(id: String): Flow<Boolean>

    fun deleteFavoriteTv(tv: Tv)
    fun insertFavoriteTv(tv: Tv)

    fun getRecommendationsTv(id: String): Flowable<Resource<TvResult>>
    fun getSimilarTv(id: String): Flowable<Resource<TvResult>>
}