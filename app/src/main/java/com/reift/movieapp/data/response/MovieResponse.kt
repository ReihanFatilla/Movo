package com.reift.movieapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

) : Parcelable

@Parcelize
data class ResultsItem(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

) : Parcelable
