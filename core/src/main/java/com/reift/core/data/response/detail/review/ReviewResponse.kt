package com.reift.core.data.response.detail.review

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>

)