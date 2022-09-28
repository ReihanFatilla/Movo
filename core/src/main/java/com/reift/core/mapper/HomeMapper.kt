package com.reift.core.mapper

import com.reift.core.data.remote.source.response.movie.MovieResponse
import com.reift.core.data.remote.source.response.tv.TvResponse
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.utils.GenreFormatter

object HomeMapper {
    fun mapResponseToDomain(input: MovieResponse): MovieResult{
        return with(input){
            MovieResult(
                page,
                totalPages,
                totalResults,
                input.results.map { movie ->
                with(movie){
                        Movie(
                            title, genreIds.map { GenreFormatter.format(it) },posterPath, voteAverage, id, adult
                        )
                    }
                }
            )
        }
    }

    fun mapResponseToDomain(input: TvResponse): TvResult{
        return with(input){
            TvResult(
                page,
                totalPages,
                totalResults,
                input.results.map { tv ->
                    with(tv){
                        Tv(
                            firstAirDate, genreIds.map { GenreFormatter.format(it) },posterPath, voteAverage, name, id
                        )
                    }
                }
            )
        }
    }
}