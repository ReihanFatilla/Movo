package com.reift.core.data.response.movie

import com.google.gson.annotations.SerializedName
import com.reift.core.domain.model.movie.ResultsItem

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)