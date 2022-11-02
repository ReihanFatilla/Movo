package com.reift.core.data.repository.detail.movie

import com.reift.core.constant.Constant
import com.reift.core.data.NetworkResource
import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.remote.RemoteDataSource
import com.reift.core.data.remote.source.response.detail.actor.ActorResponse
import com.reift.core.data.remote.source.response.detail.movie.MovieDetailResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.data.remote.source.response.detail.video.VideoResponse
import com.reift.core.data.remote.source.response.detail.wallpaper.WallpaperResponse
import com.reift.core.data.remote.source.response.movie.MovieResponse
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.movie.MovieResult
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.mapper.HomeMapper.map
import com.reift.core.mapper.MovieDetailMapper.asEntity
import com.reift.core.mapper.MovieDetailMapper.map
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

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
                return remoteDataSource.getReviewList(MOVIE, id, PAGE)
            }

        }.asFlowable()
    }

    override fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return object : NetworkResource<Wallpaper, WallpaperResponse>(){
            override fun createResult(data: WallpaperResponse): Wallpaper {
                return data.map()
            }

            override fun createCall(): Flowable<WallpaperResponse> {
                return remoteDataSource.getWallpaperList(MOVIE, id)
            }

        }.asFlowable()
    }

    override fun getMovieActors(id: String): Flowable<Resource<List<Actor>>> {
        return object : NetworkResource<List<Actor>, ActorResponse>(){
            override fun createResult(data: ActorResponse): List<Actor> {
                return data.map()
            }

            override fun createCall(): Flowable<ActorResponse> {
                return remoteDataSource.getCreditList(MOVIE, id)
            }

        }.asFlowable()
    }

    override fun getMovieVideos(id: String): Flowable<Resource<List<Video>>> {
        return object : NetworkResource<List<Video>, VideoResponse>(){
            override fun createResult(data: VideoResponse): List<Video> {
                return data.map()
            }

            override fun createCall(): Flowable<VideoResponse> {
                return remoteDataSource.getVideoList(MOVIE, id)
            }

        }.asFlowable()
    }

    override fun getRecommendationsMovies(id: String): Flowable<Resource<MovieResult>> {
        return object : NetworkResource<MovieResult, MovieResponse>(){
            override fun createResult(data: MovieResponse): MovieResult {
                return data.map()
            }

            override fun createCall(): Flowable<MovieResponse> {
                return remoteDataSource.getRecommendationsMovies(id, PAGE)
            }

        }.asFlowable()
    }

    override fun getSimilarMovies(id: String): Flowable<Resource<MovieResult>> {
        return object : NetworkResource<MovieResult, MovieResponse>(){
            override fun createResult(data: MovieResponse): MovieResult {
                return data.map()
            }

            override fun createCall(): Flowable<MovieResponse> {
                return remoteDataSource.getSimilarMovies(id, PAGE)
            }

        }.asFlowable()
    }

    override fun isFollowed(id: String): Flow<Boolean> {
        return localDataSource.getMovieFavoriteById(id).map {
            it != null
        }
    }

    override fun insertFavoriteMovie(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertFavoriteMovie(movie.asEntity())
        }
    }

    override fun deleteFavoriteMovie(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteFavoriteMovie(movie.asEntity())
        }
    }

    companion object{
        const val PAGE = "1"
        const val MOVIE = "movie"
    }

}