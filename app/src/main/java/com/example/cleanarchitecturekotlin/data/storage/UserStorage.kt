package com.example.cleanarchitecturekotlin.data.storage

import com.example.cleanarchitecturekotlin.data.storage.model.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}