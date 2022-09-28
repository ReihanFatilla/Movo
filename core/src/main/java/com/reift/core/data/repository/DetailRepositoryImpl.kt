package com.reift.core.data.repository

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.detail.DetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class DetailRepositoryImpl: DetailRepository {
    override fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>> {
        TODO("Not yet implemented")
    }

    override fun getMovieReviews(id: String): Flowable<Resource<Review>> {
        TODO("Not yet implemented")
    }

    override fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        TODO("Not yet implemented")
    }

    override fun getMovieActors(id: String): Flowable<Resource<Actor>> {
        TODO("Not yet implemented")
    }

    override fun getTvDetail(id: String): Flowable<Resource<TvDetail>> {
        TODO("Not yet implemented")
    }

    override fun getTvReviews(id: String): Flowable<Resource<Actor>> {
        TODO("Not yet implemented")
    }

    override fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        TODO("Not yet implemented")
    }

    override fun getTvActors(id: String): Flowable<Resource<Actor>> {
        TODO("Not yet implemented")
    }

    override fun isFollowed(id: String): Flow<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

    override fun deleteFavoriteMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun deleteFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

}