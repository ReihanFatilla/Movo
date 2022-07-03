package com.reift.movieapp.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.reift.movieapp.data.MovieRepository
import com.reift.movieapp.data.response.DetailResponse

class DetailViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MovieRepository = MovieRepository(application)

    val detailResponse = MutableLiveData<DetailResponse>()


    fun getMovieDetail(id: String){
        repository.getMovieDetail(
            {
                detailResponse.value = it
            },
            {},
            id
        )
    }

}