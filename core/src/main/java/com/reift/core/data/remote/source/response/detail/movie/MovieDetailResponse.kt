package com.reift.core.data.remote.source.response.detail.movie

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

    @field:SerializedName("video")
	val video: Boolean,

    @field:SerializedName("title")
	val title: String,

    @field:SerializedName("genres")
	val genres: List<GenresItem>,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("vote_count")
	val voteCount: Int,

    @field:SerializedName("overview")
	val overview: String,

    @field:SerializedName("original_title")
	val originalTitle: String,

    @field:SerializedName("runtime")
	val runtime: Int,

    @field:SerializedName("poster_path")
	val posterPath: String,

    @field:SerializedName("release_date")
	val releaseDate: String,

    @field:SerializedName("vote_average")
	val voteAverage: Double,

    @field:SerializedName("adult")
	val adult: Boolean,

    @field:SerializedName("status")
	val status: String
)