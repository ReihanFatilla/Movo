package com.reift.movieapp.presentation.home.component

import com.reift.movieapp.data.ResultsItem

data class MovieTypeData(
    val type: String? = null,
    val desc: String? = null,
    val movieType: List<ResultsItem>? = null
)
