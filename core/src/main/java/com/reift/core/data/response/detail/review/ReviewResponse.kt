package com.reift.core.data.response.detail.review

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)