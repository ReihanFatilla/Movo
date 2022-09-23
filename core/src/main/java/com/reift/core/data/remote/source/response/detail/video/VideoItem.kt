package com.reift.core.data.remote.source.response.detail.video

import com.google.gson.annotations.SerializedName

data class VideoItem(
	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("official")
	val official: Boolean,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("key")
	val key: String
)