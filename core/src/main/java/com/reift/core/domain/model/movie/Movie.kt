package com.reift.core.domain.model.movie

data class Movie (
    val originalTitle: String,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val id: Int,
    val adult: Boolean
    )
