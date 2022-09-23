package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class Actor(

	@field:SerializedName("character")
	val character: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("profile_path")
	val profilePath: String,

)