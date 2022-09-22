package com.reift.movieapp.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.reift.core.data.MovieRepository
import com.reift.movieapp.data.MovieResponse
import com.reift.core.data.response.CreditResponse
import com.reift.core.data.response.DetailResponse
import com.reift.core.data.response.ReviewResponse

class DetailViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MovieRepository = MovieRepository(application)

    val detailResponse = MutableLiveData<DetailResponse>()
    val similarResponse = MutableLiveData<MovieResponse>()
    val creditResponse = MutableLiveData<CreditResponse>()
    val reviewResponse = MutableLiveData<ReviewResponse>()


    fun getDetail(media: String, id: String){
        repository.getDetail(
            {
                detailResponse.value = it
            },
            {},
            media,
            id
        )
    }

    fun getReviewList(media: String, id: String, page: String){
        repository.getReviewList(
            {
                reviewResponse.value = it
            },
            {},
            media,
            id,
            page
        )
    }

    fun getSimilarList(media: String, id: String, region: String, page: String){
        repository.getSimilarList(
            {
                similarResponse.value = it
            },
            {},
            media,
            id,
            region,
            page
        )
    }

    fun getCreditList(media: String, id: String, region: String){
        repository.getCreditList(
            {
                creditResponse.value = it
            },
            {},
            media,
            id,
            region,
        )
    }



}