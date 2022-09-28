package com.reift.core.data

import android.util.Log
import com.reift.core.domain.model.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class NetworkResource<ResultType, RequestType> {

    private var result = PublishSubject.create<Resource<ResultType>>()

    private val mCompositeDisposable = CompositeDisposable()

    init {
        subscribe()
    }

    private fun subscribe() {
        val apiResponse = createCall()

        result.onNext(Resource.Loading())
        val response = apiResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .doOnComplete {
                mCompositeDisposable.dispose()
            }
            .subscribe (
                {
                    result.onNext(

                        Resource.Success(createResult(it))
                    )
                },{
                    result.onNext(

                        Resource.Error(it.message.toString())
                    )
                }
                    )
        mCompositeDisposable.add(response)
    }

    protected abstract fun createResult(data: RequestType): ResultType

    protected abstract fun createCall(): Flowable<RequestType>

    fun asFlowable(): Flowable<Resource<ResultType>> {
        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}