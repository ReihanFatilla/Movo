package com.reift.core.domain.model.tv

import com.google.gson.annotations.SerializedName

data class TvResult(
	val page: Int,
	val totalPages: Int,
	val totalResults: Int,
	val tv: List<Tv>
)