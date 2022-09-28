package com.reift.core.data.remote.source.response.detail.tv

import com.google.gson.annotations.SerializedName

data class TvDetailResponse(

    @field:SerializedName("number_of_episodes")
	val numberOfEpisodes: Int? = null,

    @field:SerializedName("type")
	val type: String? = null,

    @field:SerializedName("genres")
	val genres: List<GenresItem>? = null,

    @field:SerializedName("popularity")
	val popularity: Double? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int? = null,

    @field:SerializedName("vote_count")
	val voteCount: Int? = null,

    @field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

    @field:SerializedName("overview")
	val overview: String? = null,

    @field:SerializedName("seasons")
	val seasons: List<SeasonsItem>? = null,

    @field:SerializedName("poster_path")
	val posterPath: String? = null,

    @field:SerializedName("original_name")
	val originalName: String? = null,

    @field:SerializedName("vote_average")
	val voteAverage: Double? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int>? = null,

    @field:SerializedName("adult")
	val adult: Boolean? = null,

    @field:SerializedName("status")
	val status: String? = null
)