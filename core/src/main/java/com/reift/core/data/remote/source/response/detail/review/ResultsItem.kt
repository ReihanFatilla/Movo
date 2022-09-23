package com.reift.core.data.remote.source.response.detail.review

import com.google.gson.annotations.SerializedName

data class ResultsItem(

    @field:SerializedName("author_details")
	val authorDetails: AuthorDetails,

    @field:SerializedName("created_at")
	val createdAt: String,

    @field:SerializedName("content")
	val content: String

)