package com.reift.core.domain.model.movie

import com.google.gson.annotations.SerializedName

data class MovieResult(
	val page: Int,
	val totalPages: Int,
	val totalResults: Int,
	val movie: List<Movie>
)