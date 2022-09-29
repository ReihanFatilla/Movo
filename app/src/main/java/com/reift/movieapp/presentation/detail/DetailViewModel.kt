package com.reift.movieapp.presentation.detail

import androidx.lifecycle.ViewModel
import com.reift.core.domain.usecase.detail.movie.MovieDetailUseCase

class DetailViewModel(movieDetailUseCase: MovieDetailUseCase): ViewModel() {
//    private val repository: MovieRepository = MovieRepository(application)
//
//    val detailResponse = MutableLiveData<DetailResponse>()
//    val similarResponse = MutableLiveData<MovieResponse>()
//    val creditResponse = MutableLiveData<CreditResponse>()
//    val reviewResponse = MutableLiveData<ReviewResponse>()
//
//
//    fun getDetail(media: String, id: String){
//        repository.getDetail(
//            {
//                detailResponse.value = it
//            },
//            {},
//            media,
//            id
//        )
//    }
//
//    fun getReviewList(media: String, id: String, page: String){
//        repository.getReviewList(
//            {
//                reviewResponse.value = it
//            },
//            {},
//            media,
//            id,
//            page
//        )
//    }
//
//    fun getSimilarList(media: String, id: String, region: String, page: String){
//        repository.getSimilarList(
//            {
//                similarResponse.value = it
//            },
//            {},
//            media,
//            id,
//            region,
//            page
//        )
//    }
//
//    fun getCreditList(media: String, id: String, region: String){
//        repository.getCreditList(
//            {
//                creditResponse.value = it
//            },
//            {},
//            media,
//            id,
//            region,
//        )
//    }

}