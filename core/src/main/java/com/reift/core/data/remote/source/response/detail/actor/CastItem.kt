package com.reift.core.data.remote.source.response.detail.actor

import com.google.gson.annotations.SerializedName

data class CastItem(

	@field:SerializedName("character")
	val character: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("profile_path")
	val profilePath: String,
)