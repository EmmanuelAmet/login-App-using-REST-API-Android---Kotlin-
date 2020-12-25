package com.emmanuelamet.loginappapi.api

import com.emmanuelamet.loginappapi.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("users")
    suspend fun signUp(@Body user: User):Response<User>
}