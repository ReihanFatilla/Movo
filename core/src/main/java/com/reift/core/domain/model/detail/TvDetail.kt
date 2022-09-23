package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class TvDetail(
	val numberOfEpisodes: Int,

    @field:SerializedName("genres")
	val genres: List<String>,

    @field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int,

    @field:SerializedName("vote_count")
	val voteCount: Int,

    @field:SerializedName("first_air_date")
	val firstAirDate: String,

    @field:SerializedName("overview")
	val overview: String,

    @field:SerializedName("poster_path")
	val posterPath: String,

    @field:SerializedName("original_name")
	val originalName: String,

    @field:SerializedName("vote_average")
	val voteAverage: Double,

    @field:SerializedName("name")
	val name: String,

    @field:SerializedName("adult")
	val adult: Boolean,

    @field:SerializedName("status")
	val status: String
)