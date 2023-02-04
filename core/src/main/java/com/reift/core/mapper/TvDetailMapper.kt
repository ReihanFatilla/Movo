package com.reift.core.mapper

import com.reift.core.data.local.source.room.movie.MovieEntity
import com.reift.core.data.remote.source.response.detail.actor.ActorResponse
import com.reift.core.data.remote.source.response.detail.movie.MovieDetailResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.data.remote.source.response.detail.tv.TvDetailResponse
import com.reift.core.data.remote.source.response.detail.video.VideoResponse
import com.reift.core.data.remote.source.response.detail.wallpaper.WallpaperResponse
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.utils.GenreFormatter

object TvDetailMapper {
    fun TvDetailResponse.map(): TvDetail{
        return TvDetail(
            id = id ?: 0,
            title = name.orEmpty(),
            genres = genres?.map { GenreFormatter.format(it.id ?: 0) } ?: listOf(),
            voteCount = voteCount ?: 0,
            overview = overview.orEmpty(),
            posterPath = posterPath.orEmpty(),
            firstAirDate = firstAirDate.orEmpty(),
            voteAverage = voteAverage ?: 0.0,
            numberOfEpisodes = numberOfEpisodes ?: 0,
            numberOfSeasons = numberOfSeasons ?: 0,
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

    fun WallpaperResponse.map(): Wallpaper {
        val listWallpaper = backdrops?.map { wallpaper ->
             wallpaper.filePath.orEmpty()
        } ?: listOf()
        val listPoster = posters?.map { poster ->
            poster.filePath.orEmpty()
        } ?: listOf()
        return Wallpaper(listPoster, listWallpaper)
    }

    fun ActorResponse.map(): List<Actor> {
        return cast?.map {
            with(it){
                Actor(
                    character = character.orEmpty(),
                    name = name.orEmpty(),
                    profilePath = profilePath.orEmpty()
                )
            }
        } ?: listOf()
    }

    fun VideoResponse.map(): List<Video> {
        return results?.map {
            with(it){
                Video(
                    name = name.orEmpty(),
                    official = official ?: false,
                    id = id.orEmpty(),
                    key = key.orEmpty()
                )
            }
        } ?: listOf()
    }

    fun Movie.asEntity(): MovieEntity{
        return MovieEntity(
            id = id,
            title = title,
            genres = genre.toString(),
            overview = overview,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteCount = voteCount,
            voteAverage = voteAverage
        )
    }
}