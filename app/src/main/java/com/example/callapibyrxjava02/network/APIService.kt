package com.example.callapibyrxjava02.network

import com.example.callapibyrxjava02.model.MovieItem
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("marvel")
    fun getPosts(): Observable<MutableList<MovieItem>>
}