package com.reift.core.domain.usecase.detail.movie

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class MovieDetailInteractor(
    private val movieDetailRepository: MovieDetailRepository
): MovieDetailUseCase {
    override fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>> {
        return movieDetailRepository.getMovieDetail(id)
    }

    override fun getMovieReviews(id: String): Flowable<Resource<List<Review>>> {
        return movieDetailRepository.getMovieReviews(id)
    }

    override fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return movieDetailRepository.getMovieWallpapers(id)
    }

    override fun getMovieActors(id: String): Flowable<Resource<List<Actor>>> {
        return movieDetailRepository.getMovieActors(id)
    }

    override fun isFollowed(id: String): Flow<Boolean> {
        return movieDetailRepository.isFollowed(id)
    }

    override fun insertFavoriteMovie(movie: Movie) {
        return movieDetailRepository.insertFavoriteMovie(movie)
    }

    override fun deleteFavoriteMovie(movie: Movie) {
        return movieDetailRepository.deleteFavoriteMovie(movie)
    }
}