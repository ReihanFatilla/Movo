package com.reift.core.domain.model.tv

data class Tv (
    val firstAirDate: String,
    val genreIds: List<Int>,
    val posterPath: String,
    val originalName: String,
    val voteAverage: Double,
    val name: String,
    val id: Int
)
