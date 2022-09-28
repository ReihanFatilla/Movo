package com.reift.core.data.remote.source.response.detail.movie

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

    @field:SerializedName("video")
	val video: Boolean? = null,

    @field:SerializedName("title")
	val title: String? = null,

    @field:SerializedName("genres")
	val genres: List<GenresItem>? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("vote_count")
	val voteCount: Int? = null,

    @field:SerializedName("overview")
	val overview: String? = null,

    @field:SerializedName("original_title")
	val originalTitle: String? = null,

    @field:SerializedName("runtime")
	val runtime: Int? = null,

    @field:SerializedName("poster_path")
	val posterPath: String? = null,

    @field:SerializedName("release_date")
	val releaseDate: String? = null,

    @field:SerializedName("vote_average")
	val voteAverage: Double? = null,

    @field:SerializedName("adult")
	val adult: Boolean? = null,

    @field:SerializedName("status")
	val status: String? = null
)