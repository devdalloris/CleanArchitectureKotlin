package com.example.cleanarchitecturekotlin.domain.usecase

import com.example.cleanarchitecturekotlin.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekotlin.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}