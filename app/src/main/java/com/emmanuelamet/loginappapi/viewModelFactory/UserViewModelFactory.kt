package com.emmanuelamet.loginappapi.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emmanuelamet.loginappapi.repository.Repository
import com.emmanuelamet.loginappapi.viewModel.UserViewModel

class UserViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}