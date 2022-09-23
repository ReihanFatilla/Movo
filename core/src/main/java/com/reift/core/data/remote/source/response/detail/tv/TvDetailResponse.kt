package com.reift.core.data.remote.source.response.detail.tv

import com.google.gson.annotations.SerializedName

data class TvDetailResponse(

    @field:SerializedName("number_of_episodes")
	val numberOfEpisodes: Int,

    @field:SerializedName("type")
	val type: String,

    @field:SerializedName("genres")
	val genres: List<GenresItem>,

    @field:SerializedName("popularity")
	val popularity: Double,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int,

    @field:SerializedName("vote_count")
	val voteCount: Int,

    @field:SerializedName("first_air_date")
	val firstAirDate: String,

    @field:SerializedName("overview")
	val overview: String,

    @field:SerializedName("seasons")
	val seasons: List<SeasonsItem>,

    @field:SerializedName("poster_path")
	val posterPath: String,

    @field:SerializedName("original_name")
	val originalName: String,

    @field:SerializedName("vote_average")
	val voteAverage: Double,

    @field:SerializedName("name")
	val name: String,

    @field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int>,

    @field:SerializedName("adult")
	val adult: Boolean,

    @field:SerializedName("status")
	val status: String
)