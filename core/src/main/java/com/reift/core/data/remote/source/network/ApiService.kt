package com.reift.core.data.remote.source.network

import com.reift.core.data.remote.source.response.*
import com.reift.core.data.remote.source.response.detail.actor.ActorResponse
import com.reift.core.data.remote.source.response.detail.movie.MovieDetailResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.data.remote.source.response.detail.tv.TvDetailResponse
import com.reift.core.data.remote.source.response.detail.video.VideoResponse
import com.reift.core.data.remote.source.response.detail.wallpaper.WallpaperResponse
import com.reift.core.data.remote.source.response.movie.MovieResponse
import com.reift.core.data.remote.source.response.tv.TvResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Movie

    @GET("movie/{category}")
    fun getMovieByCategory(
        @Path("category")
        category: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
    ): Flowable<MovieDetailResponse>

    @GET("search/movie")
    fun searchMovieByQuery(
        @Query("api_key")
        apiKey: String,
        @Query("query")
        query: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("movie/{id}/similar")
    fun getSimilarMovies(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("movie/{id}/recommendations")
    fun getRecommendationsMovies(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    // Tv Show

    @GET("tv/{category}")
    fun getTvByCategory(
        @Path("category")
        category: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<TvResponse>

    @GET("tv/{id}")
    fun getTvDetail(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
    ): Flowable<TvDetailResponse>

    @GET("search/tv")
    fun searchTvByQuery(
        @Query("api_key")
        apiKey: String,
        @Query("query")
        query: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<TvResponse>

    @GET("tv/{id}/similar")
    fun getSimilarTv(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<TvResponse>

    @GET("tv/{id}/recommendations")
    fun getRecommendationsTv(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<TvResponse>

    // Details

    @GET("{media}/{id}/reviews")
    fun getReviewList(
        @Path("media")
        media: String,
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("page")
        page: String
    ): Flowable<ReviewResponse>

    @GET("{media}/{id}/credits")
    fun getCreditList(
        @Path("media")
        media: String,
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String
    ): Flowable<ActorResponse>

    @GET("{media}/{id}/videos")
    fun getVideoList(
        @Path("media")
        media: String,
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String
    ): Flowable<VideoResponse>

    @GET("{media}/{id}/images")
    fun getWallpaperList(
        @Path("media")
        media: String,
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String
    ): Flowable<WallpaperResponse>

}