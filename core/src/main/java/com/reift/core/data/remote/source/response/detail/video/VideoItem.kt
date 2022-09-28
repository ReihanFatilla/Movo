package com.reift.core.data.remote.source.response.detail.video

import com.google.gson.annotations.SerializedName

data class VideoItem(
	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("official")
	val official: Boolean? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)