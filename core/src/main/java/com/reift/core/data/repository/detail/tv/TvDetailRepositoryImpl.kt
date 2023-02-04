package com.reift.core.data.repository.detail.tv

import com.reift.core.data.NetworkResource
import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.remote.RemoteDataSource
import com.reift.core.data.remote.source.response.detail.actor.ActorResponse
import com.reift.core.data.remote.source.response.detail.review.ReviewResponse
import com.reift.core.data.remote.source.response.detail.tv.TvDetailResponse
import com.reift.core.data.remote.source.response.detail.video.VideoResponse
import com.reift.core.data.remote.source.response.detail.wallpaper.WallpaperResponse
import com.reift.core.data.remote.source.response.tv.TvResponse
import com.reift.core.data.repository.detail.movie.MovieDetailRepositoryImpl
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.domain.repository.detail.tv.TvDetailRepository
import com.reift.core.mapper.HomeMapper.map
import com.reift.core.mapper.MovieDetailMapper.map
import com.reift.core.mapper.TvDetailMapper.map
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class TvDetailRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
): TvDetailRepository {
    override fun getTvDetail(id: String): Flowable<Resource<TvDetail>> {
        return object : NetworkResource<TvDetail, TvDetailResponse>() {
            override fun createResult(data: TvDetailResponse): TvDetail {
                return data.map()
            }

            override fun createCall(): Flowable<TvDetailResponse> {
                return remoteDataSource.getTvDetail(id)
            }

        }.asFlowable()
    }

    override fun getTvReviews(id: String): Flowable<Resource<List<Review>>> {
        return object : NetworkResource<List<Review>, ReviewResponse>(){
            override fun createResult(data: ReviewResponse): List<Review> {
                return data.map()
            }

            override fun createCall(): Flowable<ReviewResponse> {
                return remoteDataSource.getReviewList(TV, id, PAGE)
            }

        }.asFlowable()
    }

    override fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return object: NetworkResource<Wallpaper, WallpaperResponse>(){
            override fun createResult(data: WallpaperResponse): Wallpaper {
                return data.map()
            }

            override fun createCall(): Flowable<WallpaperResponse> {
                return remoteDataSource.getWallpaperList(TV, id)
            }

        }.asFlowable()
    }

    override fun getTvActors(id: String): Flowable<Resource<List<Actor>>> {
        return object : NetworkResource<List<Actor>, ActorResponse>(){
            override fun createResult(data: ActorResponse): List<Actor> {
                return data.map()
            }

            override fun createCall(): Flowable<ActorResponse> {
                return remoteDataSource.getCreditList(TV, id)
            }

        }.asFlowable()
    }

    override fun getTvVideos(id: String): Flowable<Resource<List<Video>>> {
        return object : NetworkResource<List<Video>, VideoResponse>(){
            override fun createResult(data: VideoResponse): List<Video> {
                return data.map()
            }

            override fun createCall(): Flowable<VideoResponse> {
                return remoteDataSource.getVideoList(MovieDetailRepositoryImpl.MOVIE, id)
            }

        }.asFlowable()
    }

    override fun isFollowed(id: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

    override fun deleteFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

    override fun getRecommendationsTv(id: String): Flowable<Resource<TvResult>> {
        return object : NetworkResource<TvResult, TvResponse>(){
            override fun createResult(data: TvResponse): TvResult {
                return data.map()
            }

            override fun createCall(): Flowable<TvResponse> {
                return remoteDataSource.getRecommendationsTv(id, MovieDetailRepositoryImpl.PAGE)
            }

        }.asFlowable()
    }

    override fun getSimilarTv(id: String): Flowable<Resource<TvResult>> {
        return object : NetworkResource<TvResult, TvResponse>(){
            override fun createResult(data: TvResponse): TvResult {
                return data.map()
            }

            override fun createCall(): Flowable<TvResponse> {
                return remoteDataSource.getSimilarTv(id, MovieDetailRepositoryImpl.PAGE)
            }

        }.asFlowable()
    }

    companion object{
        const val PAGE = "1"
        const val TV = "tv"
    }
}