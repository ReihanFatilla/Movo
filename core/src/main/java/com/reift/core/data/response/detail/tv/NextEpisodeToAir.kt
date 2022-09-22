package com.reift.core.data.response.detail.tv

import com.google.gson.annotations.SerializedName

data class NextEpisodeToAir(

	@field:SerializedName("production_code")
	val productionCode: String,

	@field:SerializedName("air_date")
	val airDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("episode_number")
	val episodeNumber: Int,

	@field:SerializedName("show_id")
	val showId: Int,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("season_number")
	val seasonNumber: Int,

	@field:SerializedName("runtime")
	val runtime: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("still_path")
	val stillPath: Any,

	@field:SerializedName("vote_count")
	val voteCount: Int
)