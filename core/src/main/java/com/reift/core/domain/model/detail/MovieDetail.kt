package com.reift.core.domain.model.detail

data class MovieDetail(
	val video: Boolean,
	val title: String,
	val genres: List<String>,
	val voteCount: Int,
	val overview: String,
	val posterPath: String,
	val releaseDate: String,
	val voteAverage: Double,
)