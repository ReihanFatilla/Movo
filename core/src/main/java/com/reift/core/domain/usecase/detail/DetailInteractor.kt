package com.reift.core.domain.usecase.detail

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.detail.DetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class DetailInteractor(
    private val detailRepository: DetailRepository
): DetailUseCase {
    override fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>> {
        return detailRepository.getMovieDetail(id)
    }

    override fun getMovieReviews(id: String): Flowable<Resource<Review>> {
        return detailRepository.getMovieReviews(id)
    }

    override fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return detailRepository.getMovieWallpapers(id)
    }

    override fun getMovieActors(id: String): Flowable<Resource<Actor>> {
        return detailRepository.getMovieActors(id)
    }

    override fun getTvDetail(id: String): Flowable<Resource<TvDetail>> {
        return detailRepository.getTvDetail(id)
    }

    override fun getTvReviews(id: String): Flowable<Resource<Actor>> {
        return detailRepository.getTvReviews(id)
    }

    override fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return detailRepository.getTvWallpapers(id)
    }

    override fun getTvActors(id: String): Flowable<Resource<Actor>> {
        return detailRepository.getTvActors(id)
    }

    override fun isFollowed(id: String): Flow<Boolean?> {
        return detailRepository.isFollowed(id)
    }

    override fun insertFavoriteMovie(movie: Movie) {
        return detailRepository.insertFavoriteMovie(movie)
    }

    override fun insertFavoriteTv(tv: Tv) {
        return detailRepository.insertFavoriteTv(tv)
    }

    override fun deleteFavoriteMovie(movie: Movie) {
        return detailRepository.deleteFavoriteMovie(movie)
    }

    override fun deleteFavoriteTv(tv: Tv) {
        return detailRepository.deleteFavoriteTv(tv)
    }
}