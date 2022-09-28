package com.reift.core.domain.model.tv

data class Tv (
    val firstAirDate: String,
    val genre: List<String>,
    val posterPath: String,
    val voteAverage: Double,
    val name: String,
    val id: Int
)
