package com.reift.core.data.remote.source.response.detail.wallpaper

import com.google.gson.annotations.SerializedName

data class WallpaperResponse(

    @field:SerializedName("backdrops")
	val backdrops: List<BackdropsItem>? = null,

    @field:SerializedName("posters")
	val posters: List<PostersItem>? = null
)