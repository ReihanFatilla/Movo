package com.reift.core.data.repository.detail.tv

import com.reift.core.data.local.LocalDataSource
import com.reift.core.data.remote.RemoteDataSource
import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.Actor
import com.reift.core.domain.model.detail.TvDetail
import com.reift.core.domain.model.detail.Wallpaper
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.detail.movie.MovieDetailRepository
import com.reift.core.domain.repository.detail.tv.TvDetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class TvDetailRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
): TvDetailRepository {
    override fun getTvDetail(id: String): Flowable<Resource<TvDetail>> {
        TODO("Not yet implemented")
    }

    override fun getTvReviews(id: String): Flowable<Resource<List<Actor>>> {
        TODO("Not yet implemented")
    }

    override fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        TODO("Not yet implemented")
    }

    override fun getTvActors(id: String): Flowable<Resource<List<Actor>>> {
        TODO("Not yet implemented")
    }

    override fun isFollowed(id: String): Flow<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

    override fun deleteFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }
}