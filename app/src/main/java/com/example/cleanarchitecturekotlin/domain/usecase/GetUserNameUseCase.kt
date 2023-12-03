package com.example.cleanarchitecturekotlin.domain.usecase

import com.example.cleanarchitecturekotlin.domain.models.UserName
import com.example.cleanarchitecturekotlin.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}