package com.reift.core.data.response.detail.wallpaper

import com.google.gson.annotations.SerializedName

data class BackdropsItem(

	@field:SerializedName("aspect_ratio")
	val aspectRatio: Double,

	@field:SerializedName("file_path")
	val filePath: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("iso_639_1")
	val iso6391: Any,

	@field:SerializedName("vote_count")
	val voteCount: Int,

	@field:SerializedName("height")
	val height: Int
)