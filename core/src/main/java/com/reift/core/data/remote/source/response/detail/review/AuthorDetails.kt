package com.reift.core.data.remote.source.response.detail.review

import com.google.gson.annotations.SerializedName

data class AuthorDetails(

	@field:SerializedName("avatar_path")
	val avatarPath: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("username")
	val username: String? = null
)