package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class TvDetail(
	val title: String,
	val numberOfEpisodes: Int,
	val genres: List<String>,
	val numberOfSeasons: Int,
	val voteCount: Int,
	val firstAirDate: String,
	val overview: String,
	val posterPath: String,
	val voteAverage: Double,
)