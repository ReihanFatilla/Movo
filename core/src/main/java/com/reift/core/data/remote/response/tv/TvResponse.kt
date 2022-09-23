package com.reift.core.data.remote.response.tv

import com.google.gson.annotations.SerializedName

data class TvResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)