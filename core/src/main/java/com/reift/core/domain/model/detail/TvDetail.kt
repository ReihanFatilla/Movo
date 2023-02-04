package com.reift.core.domain.model.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvDetail(
	val id: Int,
	val title: String,
	val numberOfEpisodes: Int,
	val genres: List<String>,
	val numberOfSeasons: Int,
	val voteCount: Int,
	val firstAirDate: String,
	val overview: String,
	val posterPath: String,
	val voteAverage: Double,
): Parcelable