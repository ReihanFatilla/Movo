package com.reift.core.data.remote.source.response.detail.video

import com.google.gson.annotations.SerializedName

data class VideoResponse(
	@field:SerializedName("results")
	val results: List<VideoItem>
)