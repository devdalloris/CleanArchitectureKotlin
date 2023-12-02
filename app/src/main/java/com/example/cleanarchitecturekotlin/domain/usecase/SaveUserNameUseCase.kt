package com.example.cleanarchitecturekotlin.domain.usecase

import com.example.cleanarchitecturekotlin.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        if(param.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}