package com.reift.core.domain.model.detail.wallpaper

import com.google.gson.annotations.SerializedName

data class PostersItem(
	@field:SerializedName("file_path")
	val filePath: String
)