package com.reift.core.data.remote.response.detail.wallpaper

import com.google.gson.annotations.SerializedName

data class PostersItem(
	@field:SerializedName("file_path")
	val filePath: String
)