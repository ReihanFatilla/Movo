package com.reift.core.data.response.detail.wallpaper

import com.google.gson.annotations.SerializedName

data class WallpaperResponse(

	@field:SerializedName("backdrops")
	val backdrops: List<BackdropsItem>,

	@field:SerializedName("posters")
	val posters: List<PostersItem>
)