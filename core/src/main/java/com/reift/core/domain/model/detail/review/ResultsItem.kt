package com.reift.core.domain.model.detail.review

import com.google.gson.annotations.SerializedName
import com.reift.core.domain.model.detail.review.AuthorDetails

data class ResultsItem(

    @field:SerializedName("author_details")
	val authorDetails: AuthorDetails,

    @field:SerializedName("created_at")
	val createdAt: String,

    @field:SerializedName("content")
	val content: String

)