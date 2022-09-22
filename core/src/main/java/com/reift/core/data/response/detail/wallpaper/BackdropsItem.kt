package com.reift.core.data.response.detail.wallpaper

import com.google.gson.annotations.SerializedName

data class BackdropsItem(
	@field:SerializedName("file_path")
	val filePath: String,
)