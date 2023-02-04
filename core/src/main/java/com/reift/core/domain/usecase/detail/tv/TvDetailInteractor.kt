package com.reift.core.domain.usecase.detail.tv

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.model.tv.TvResult
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.domain.repository.detail.tv.TvDetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class TvDetailInteractor(
    private val tvDetailRepository: TvDetailRepository
): TvDetailUseCase {
    override fun getTvDetail(id: String): Flowable<Resource<TvDetail>> {
        return tvDetailRepository.getTvDetail(id)
    }

    override fun getTvReviews(id: String): Flowable<Resource<List<Review>>> {
        return tvDetailRepository.getTvReviews(id)
    }

    override fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return tvDetailRepository.getTvWallpapers(id)
    }

    override fun getTvActors(id: String): Flowable<Resource<List<Actor>>> {
        return tvDetailRepository.getTvActors(id)
    }

    override fun getTvVideos(id: String): Flowable<Resource<List<Video>>> {
        return tvDetailRepository.getTvVideos(id)
    }

    override fun isFollowed(id: String): Flow<Boolean> {
        return tvDetailRepository.isFollowed(id)
    }

    override fun deleteFavoriteTv(tv: Tv) {
        return tvDetailRepository.deleteFavoriteTv(tv)
    }

    override fun insertFavoriteTv(tv: Tv) {
        return tvDetailRepository.insertFavoriteTv(tv)
    }

    override fun getRecommendationsTv(id: String): Flowable<Resource<TvResult>> {
        return tvDetailRepository.getRecommendationsTv(id)
    }

    override fun getSimilarTv(id: String): Flowable<Resource<TvResult>> {
        return tvDetailRepository.getSimilarTv(id)
    }

}