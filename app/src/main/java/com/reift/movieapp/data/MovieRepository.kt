package com.reift.movieapp.data

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.reift.movieapp.data.remote.ApiClient
import com.reift.movieapp.data.response.DetailResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieRepository(context: Context) {
    private val ai: ApplicationInfo = context.packageManager
        .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
    private val apiKey = "cc624f824bf4aae323fb0cc15680e65c"
//        ai.metaData["apiKey"].toString()

    private val apiService = ApiClient.getApiService()

    fun getMovieList(
        responseHandler: (MovieResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        type: String,
        region: String,
        page: String
    ){
        apiService.getMovieList(type, apiKey, region, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun getTVShowList(
        responseHandler: (MovieResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        type: String,
        region: String,
        page: String
    ){
        apiService.getTVShowList(type, apiKey, region, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun getTrendingList(
        responseHandler: (MovieResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        media: String,
        region: String,
        page: String
    ){
        apiService.getTrendingList(media, apiKey, region, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun getMovieDetail(
        responseHandler: (DetailResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        id: String
    ){
        apiService.getMovieDetail(id, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun getMovieRecommendationsById(
        responseHandler: (MovieResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        id: String,
        region: String,
        page: String
    ){
        apiService.getMovieRecommendationsById(id, apiKey, region, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            }
            )
    }

    fun getMovieSortBY(
        responseHandler: (MovieResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        sortBy: String,
        region: String,
        page: String
    ){
        apiService.getMovieSortBy(apiKey, sortBy, region, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun searchMovieBy(
        responseHandler: (MovieResponse) -> Unit,
        errorHandler: (Throwable) -> Unit,
        searchBy: String,
        query: String,
        region: String,
        page: String
    ){
        apiService.searchMovieBy(searchBy, apiKey, query, region, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
}