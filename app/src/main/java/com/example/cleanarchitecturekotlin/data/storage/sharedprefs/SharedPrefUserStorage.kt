package com.example.cleanarchitecturekotlin.data.storage.sharedprefs

import android.content.Context
import com.example.cleanarchitecturekotlin.data.storage.UserStorage
import com.example.cleanarchitecturekotlin.data.storage.model.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "default lastName"
private const val DEFAULT_FIRST_NAME = "default firstName"

class SharedPrefUserStorage(context: Context): UserStorage {
    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(
            KEY_FIRST_NAME,
            DEFAULT_FIRST_NAME
        )?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(
            KEY_LAST_NAME,
            DEFAULT_LAST_NAME
        )?: DEFAULT_LAST_NAME
        return User(firstName, lastName)
    }

}