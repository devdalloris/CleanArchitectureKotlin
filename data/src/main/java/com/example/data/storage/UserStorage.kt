package com.example.data.storage

import com.example.data.storage.model.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}