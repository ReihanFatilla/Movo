package com.reift.core.data.repository

import com.reift.core.constant.Constant
import com.reift.core.data.NetworkResource
import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.remote.RemoteDataSource
import com.reift.core.data.remote.source.response.detail.movie.MovieDetailResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.mapper.MovieDetailMapper.map
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class MovieDetailRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
): MovieDetailRepository {
    override fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>> {
        return object : NetworkResource<MovieDetail, MovieDetailResponse>(){
            override fun createResult(data: MovieDetailResponse): MovieDetail {
                return data.map()
            }

            override fun createCall(): Flowable<MovieDetailResponse> {
                return remoteDataSource.getMovieDetail(id)
            }

        }.asFlowable()
    }

    override fun getMovieReviews(id: String): Flowable<Resource<List<Review>>> {
        return object : NetworkResource<List<Review>, ReviewResponse>(){
            override fun createResult(data: ReviewResponse): List<Review> {
                return data.map()
            }

            override fun createCall(): Flowable<ReviewResponse> {
                return remoteDataSource.getReviewList(Constant.MEDIA_MOVIE, id, PAGE)
            }

        }.asFlowable()
    }

    override fun getMovieWallpapers(id: String): Flowable<Resource<List<Wallpaper>>> {
        TODO("Not yet implemented")
    }

    override fun getMovieActors(id: String): Flowable<Resource<List<Actor>>> {
        TODO("Not yet implemented")
    }

    override fun getTvDetail(id: String): Flowable<Resource<TvDetail>> {
        TODO("Not yet implemented")
    }

    override fun getTvReviews(id: String): Flowable<Resource<List<Actor>>> {
        TODO("Not yet implemented")
    }

    override fun getTvWallpapers(id: String): Flowable<Resource<List<Wallpaper>>> {
        TODO("Not yet implemented")
    }

    override fun getTvActors(id: String): Flowable<Resource<List<Actor>>> {
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

    companion object{
        const val PAGE = "0"
    }

}