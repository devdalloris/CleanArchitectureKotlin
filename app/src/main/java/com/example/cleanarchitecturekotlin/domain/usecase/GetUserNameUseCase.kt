package com.example.cleanarchitecturekotlin.domain.usecase

import com.example.cleanarchitecturekotlin.domain.models.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "Kaporo", lastName="Kael")
    }
}