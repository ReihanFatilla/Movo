package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class Actor(
	val character: String,
	val name: String,
	val profilePath: String,
)