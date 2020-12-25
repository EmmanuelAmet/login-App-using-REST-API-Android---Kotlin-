package com.emmanuelamet.loginappapi.api

import com.emmanuelamet.loginappapi.utils.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiInstance {
    private val service by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:Api by lazy {
        service.create(Api::class.java)
    }
}