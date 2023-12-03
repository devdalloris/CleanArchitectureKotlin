package com.example.cleanarchitecturekotlin.data.repository

import com.example.cleanarchitecturekotlin.data.storage.model.User
import com.example.cleanarchitecturekotlin.data.storage.UserStorage
import com.example.cleanarchitecturekotlin.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekotlin.domain.models.UserName
import com.example.cleanarchitecturekotlin.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        var user = User(firstName = saveParam.name, lastName = "")

        var result: Boolean = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}