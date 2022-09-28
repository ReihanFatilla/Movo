package com.reift.core.data.remote.source.response.movie

import com.google.gson.annotations.SerializedName

data class MovieItem(

	@field:SerializedName("original_title")
	val originalTitle: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("poster_path")
	val posterPath: String? = "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",

	@field:SerializedName("genre_ids")
	val genreIds: List<Int>,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("adult")
	val adult: Boolean

)