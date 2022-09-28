package com.reift.core.data.remote.source.response.detail.review

import com.google.gson.annotations.SerializedName

data class ReviewItem(

    @field:SerializedName("author_details")
	val authorDetails: AuthorDetails? = null,

    @field:SerializedName("created_at")
	val createdAt: String? = null,

    @field:SerializedName("content")
	val content: String? = null

)