package com.reift.core.data.remote

import com.reift.core.data.remote.source.network.ApiService
import com.reift.core.data.remote.source.response.detail.actor.ActorResponse
import com.reift.core.data.remote.source.response.detail.movie.MovieDetailResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.data.remote.source.response.detail.tv.TvDetailResponse
import com.reift.core.data.remote.source.response.detail.video.VideoResponse
import com.reift.core.data.remote.source.response.movie.MovieResponse
import com.reift.core.data.remote.source.response.tv.TvResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class RemoteDataSource(
    private val apiService: ApiService
) {

    private val apiKey = "cc624f824bf4aae323fb0cc15680e65c"
    private val region = "ID"

    // Movie

   fun getMoviesByCategory(
       category: String,
       page: String
   ): Flowable<MovieResponse> {
       return apiService.getMovieByCategory(category, apiKey, region, page)
   }

    fun getMovieDetail(
        id: String
    ): Flowable<MovieDetailResponse> {
        return apiService.getMovieDetail(id, apiKey)
    }

    fun searchMovieByQuery(
        query: String,
        page: String
    ): Flowable<MovieResponse> {
        return apiService.searchMovieByQuery(apiKey, query, region, page)
    }

    fun getSimilarMovies(
        id: String,
        page: String
    ): Flowable<MovieResponse> {
        return apiService.getSimilarMovies(id, apiKey, region, page)
    }

    fun getRecommendationsMovies(
        id: String,
        page: String
    ): Flowable<MovieResponse> {
        return apiService.getRecommendationsMovies(id, apiKey, region, page)
    }

    // Tv Show

    fun getTvByCategory(
        category: String,
        page: String
    ): Flowable<TvResponse> {
        return apiService.getTvByCategory(category, apiKey, region, page)
    }

    fun getTvDetail(
        id: String
    ): Flowable<TvDetailResponse> {
        return apiService.getTvDetail(id, apiKey)
    }

    fun searchTvByQuery(
        query: String,
        page: String
    ): Flowable<TvResponse> {
        return apiService.searchTvByQuery(apiKey ,query, region, page)
    }

    fun getSimilarTv(
        id: String,
        page: String
    ): Flowable<TvResponse> {
        return apiService.getSimilarTv(id, apiKey, region, page)
    }

    fun getRecommendationsTv(
        id: String,
        page: String
    ): Flowable<TvResponse> {
        return apiService.getRecommendationsTv(id, apiKey, region, page)
    }

    // Detail

    fun getReviewList(
        media: String,
        id: String,
        page: String
    ): Flowable<ReviewResponse> {
        return apiService.getReviewList(media, id, apiKey, page)
    }

    fun getCreditList(
        media: String,
        id: String,
    ): Flowable<ActorResponse> {
        return apiService.getCreditList(media, id, apiKey, region)
    }

    fun getVideoList(
        media: String,
        id: String,
    ): Flowable<VideoResponse> {
        return apiService.getVideoList(media, id, apiKey)
    }

    fun getWallpaperList(
        media: String,
        id: String,
    ): Flowable<VideoResponse> {
        return apiService.getVideoList(media, id, apiKey)
    }


}