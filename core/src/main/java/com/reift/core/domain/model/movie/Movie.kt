package com.reift.core.domain.model.movie

data class Movie (
    val title: String,
    val genre: List<String>,
    val posterPath: String,
    val voteAverage: Double,
    val id: Int,
    val adult: Boolean
    )
