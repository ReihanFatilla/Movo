package com.reift.core.data.remote.response.detail.actor

import com.google.gson.annotations.SerializedName

data class ActorResponse(

	@field:SerializedName("cast")
	val cast: List<CastItem>

)