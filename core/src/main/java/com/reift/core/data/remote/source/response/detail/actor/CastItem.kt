package com.reift.core.data.remote.source.response.detail.actor

import com.google.gson.annotations.SerializedName

data class CastItem(

	@field:SerializedName("character")
	val character: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_path")
	val profilePath: String? = null,
)