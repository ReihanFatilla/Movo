package com.reift.movieapp.data.remote

import com.reift.movieapp.data.MovieResponse
import com.reift.movieapp.data.response.DetailResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/{type}")
    fun getMovieList(
        @Path("type")
        type: String,
        @Query("api_key")
        apiKey: String,
        @Query("region")
        region: String,
        @Query("page")
        page: String
    ): Flowable<MovieResponse>

    @GET("tv/{type}")
    fun getTVShowList(
        @Path("type")
        type: String,
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
        apiKey: String
    ): Flowable<DetailResponse>

    @GET("tv/{id}")
    fun getTvShowDetail(
        @Path("id")
        id: String,
        @Query("api_key")
        apiKey: String
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