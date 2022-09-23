package com.reift.core.data.remote.response.detail.review

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("results")
	val results: List<ReviewItem>

)