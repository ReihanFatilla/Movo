package com.reift.core.domain.model.tv

import com.google.gson.annotations.SerializedName

data class Tv(
	val page: Int,
	val totalPages: Int,
	val totalResults: Int,
	val firstAirDate: String,
	val genreIds: List<Int>,
	val posterPath: String,
	val originalName: String,
	val voteAverage: Double,
	val name: String,
	val id: Int
)