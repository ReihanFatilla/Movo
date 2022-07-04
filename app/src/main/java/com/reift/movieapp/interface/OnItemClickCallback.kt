package com.reift.movieapp.`interface`

import com.reift.movieapp.data.MovieResponse
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.data.response.DetailResponse

interface OnItemClickCallback {
    fun onItemClicked(data: ResultsItem)
}