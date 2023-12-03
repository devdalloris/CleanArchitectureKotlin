package com.example.cleanarchitecturekotlin.domain.repository

import com.example.cleanarchitecturekotlin.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekotlin.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam:SaveUserNameParam):Boolean
    fun getName():UserName
}