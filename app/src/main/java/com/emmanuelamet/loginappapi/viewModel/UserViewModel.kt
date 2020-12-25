package com.emmanuelamet.loginappapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emmanuelamet.loginappapi.model.User
import com.emmanuelamet.loginappapi.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: Repository): ViewModel() {
    val userResponse: MutableLiveData<Response<User>> = MutableLiveData()

     fun signUp(user: User){
        viewModelScope.launch {
            val response = repository.signUp(user)
            userResponse.value = response
        }
    }
}