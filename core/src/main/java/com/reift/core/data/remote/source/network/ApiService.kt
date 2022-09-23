package com.reift.core.data.remote.source.network

import com.reift.movieapp.data.MovieResponse
import com.reift.core.data.response.CreditResponse
import com.reift.core.data.response.DetailResponse
import com.reift.core.data.response.ReviewResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{media}/{type}")
    fun getMovieTVList(
        @Path("media")
        media: String,
        @Path("type")
        type: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

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

    @GET("{media}/{id}/similar")
    fun getSimilarList(
        @Path("media")
        media: String,
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

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
    ): Flowable<CreditResponse>

    @GET("{media}/{id}")
    fun getDetail(
        @Path("media")
        media: String,
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
    ): Flowable<DetailResponse>

    @GET("trending/{media}/day")
    fun getTrendingList(
        @Path("media")
        media: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("movie/{id}/recommendations")
    fun getMovieRecommendationsById(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("discover/movie")
    fun getMovieSortBy(
        @Query("api_key")
        apiKey: String,
        @Query("sort_by")
        sortBy: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("search/{searchBy}")
    fun searchMovieBy(
        @Path("searchBy")
        searchBy: String,
        @Query("api_key")
        apiKey: String,
        @Query("query")
        query: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

}