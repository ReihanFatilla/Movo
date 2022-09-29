package com.reift.core.domain.usecase.detail.tv

import com.reift.core.domain.model.Resource
import com.reift.core.domain.model.detail.*
import com.reift.core.domain.model.movie.Movie
import com.reift.core.domain.model.tv.Tv
import com.reift.core.domain.repository.detail.DetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class TvDetailInteractor(
    private val detailRepository: DetailRepository
): TvDetailUseCase {
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

    override fun deleteFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteTv(tv: Tv) {
        TODO("Not yet implemented")
    }

}