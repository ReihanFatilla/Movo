package com.reift.core.domain.model.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetail(
	val id: Int,
	val video: Boolean,
	val title: String,
	val genres: List<String>,
	val voteCount: Int,
	val duration: Int,
	val overview: String,
	val posterPath: String,
	val releaseDate: String,
	val voteAverage: Double,
): Parcelable