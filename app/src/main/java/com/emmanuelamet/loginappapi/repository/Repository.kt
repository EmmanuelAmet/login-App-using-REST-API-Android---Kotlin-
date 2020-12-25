package com.emmanuelamet.loginappapi.repository

import com.emmanuelamet.loginappapi.api.ApiInstance
import com.emmanuelamet.loginappapi.model.User
import retrofit2.Response

class Repository {
    suspend fun signUp(user: User): Response<User>{
        return ApiInstance.api.signUp(user)
    }
}