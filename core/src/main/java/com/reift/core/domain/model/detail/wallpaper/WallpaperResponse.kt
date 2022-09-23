package com.reift.core.domain.model.detail.wallpaper

import com.google.gson.annotations.SerializedName
import com.reift.core.domain.model.detail.wallpaper.BackdropsItem
import com.reift.core.domain.model.detail.wallpaper.PostersItem

data class WallpaperResponse(

    @field:SerializedName("backdrops")
	val backdrops: List<BackdropsItem>,

    @field:SerializedName("posters")
	val posters: List<PostersItem>
)