package com.example.callapibyrxjava02.constants

import com.example.callapibyrxjava02.network.APIService
import com.example.callapibyrxjava02.network.RetrofitClient

object MovieConstants {
    private const val BASE_URL = "https://simplifiedcoding.net/demos/"

    val getAPIService : APIService
    get() = RetrofitClient.getRetrofitClient(BASE_URL).create(APIService::class.java)
}