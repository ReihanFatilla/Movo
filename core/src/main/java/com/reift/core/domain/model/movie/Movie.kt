package com.reift.core.domain.model.movie

import com.google.gson.annotations.SerializedName

data class Movie(
	val page: Int,
	val totalPages: Int,
	val totalResults: Int,
	val originalTitle: String,
	val title: String,
	val posterPath: String,
	val voteAverage: Double,
	val id: Int,
	val adult: Boolean
)