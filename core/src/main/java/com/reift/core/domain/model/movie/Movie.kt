package com.reift.core.domain.model.movie

data class Movie (
    val title: String,
    val overview: String,
    val genre: List<String>,
    val releaseDate: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val id: Int,
    val adult: Boolean
    )
