package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class Review(
	val avatarPath: String,
	val name: String,
	val rating: Double,
	val username: String,
	val content: String
)