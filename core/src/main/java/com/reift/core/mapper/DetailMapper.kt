package com.reift.core.mapper

import com.reift.core.data.remote.source.response.detail.movie.MovieDetailResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.domain.model.detail.MovieDetail
import com.reift.core.domain.model.detail.Review
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.utils.GenreFormatter

object DetailMapper {
    fun MovieDetailResponse.map(): MovieDetail{
        return MovieDetail(
            video = video ?: false,
            title = title.orEmpty(),
            genres = genres?.map { GenreFormatter.format(it.id ?: 0) } ?: listOf(),
            voteCount = voteCount ?: 0,
            overview = overview.orEmpty(),
            posterPath = posterPath.orEmpty(),
            releaseDate = releaseDate.orEmpty(),
            voteAverage = voteAverage ?: 0.0
        )
    }

    fun ReviewResponse.map(): List<Review> {
        return results?.map { review ->
            with(review) {
                Review(
                    avatarPath = authorDetails?.avatarPath.orEmpty(),
                    name = authorDetails?.name.orEmpty(),
                    rating = authorDetails?.rating ?: 0.0,
                    username = authorDetails?.username.orEmpty(),
                    content = content.orEmpty()
                )
            }
        } ?: listOf()
    }
}