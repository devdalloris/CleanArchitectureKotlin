package com.example.cleanarchitecturekotlin.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        com.example.data.repository.UserRepositoryImpl(
            userStorage = com.example.data.storage.sharedprefs.SharedPrefUserStorage(
                context = context
            )
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        com.example.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}