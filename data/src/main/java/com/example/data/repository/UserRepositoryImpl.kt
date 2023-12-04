package com.example.data.repository

import com.example.data.storage.UserStorage
import com.example.data.storage.model.User
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

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