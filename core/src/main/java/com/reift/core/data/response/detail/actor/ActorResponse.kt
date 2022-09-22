package com.reift.core.data.response.detail.actor

import com.google.gson.annotations.SerializedName

data class ActorResponse(

	@field:SerializedName("cast")
	val cast: List<CastItem>,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("crew")
	val crew: List<CrewItem>
)