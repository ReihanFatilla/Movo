package com.reift.core.data.remote.source.response.detail.review

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: List<ReviewItem>? = null

)