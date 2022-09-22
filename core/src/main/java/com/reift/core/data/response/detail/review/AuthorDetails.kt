package com.reift.core.data.response.detail.review

import com.google.gson.annotations.SerializedName

data class AuthorDetails(

	@field:SerializedName("avatar_path")
	val avatarPath: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("username")
	val username: String
)