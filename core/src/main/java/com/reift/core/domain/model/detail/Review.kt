package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class Review(

	@field:SerializedName("avatar_path")
	val avatarPath: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("username")
	val username: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("content")
	val content: String
)