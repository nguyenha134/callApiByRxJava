package com.example.callapibyrxjava02.repository

import androidx.lifecycle.MutableLiveData
import com.example.callapibyrxjava02.constants.MovieConstants
import com.example.callapibyrxjava02.model.MovieItem
import com.example.callapibyrxjava02.network.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {

    private val apiService: APIService = MovieConstants.getAPIService
    private val compositeDisposable = CompositeDisposable()

    val getMovieModelLiveData: MutableLiveData<MutableList<MovieItem>>
        get() {
            val data: MutableLiveData<MutableList<MovieItem>> =
                MutableLiveData<MutableList<MovieItem>>()
            compositeDisposable.add(apiService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { postModels ->
                    if (postModels != null) {
                        data.value = postModels
                    }
                }
            )
            return data
        }
}