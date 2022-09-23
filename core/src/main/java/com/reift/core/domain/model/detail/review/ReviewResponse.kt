package com.reift.core.domain.model.detail.review

import com.google.gson.annotations.SerializedName
import com.reift.core.domain.model.detail.review.ResultsItem

data class ReviewResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>

)