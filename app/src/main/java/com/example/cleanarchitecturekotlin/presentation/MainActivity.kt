package com.example.cleanarchitecturekotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecturekotlin.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturekotlin.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecturekotlin.databinding.ActivityMainBinding
import com.example.cleanarchitecturekotlin.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekotlin.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekotlin.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(
                context = applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameParam by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetUserName.setOnClickListener {
            var username = getUserNameUseCase.execute()
            binding.txUserName.text = "${username.firstName} ${username.lastName}"
        }
        binding.btnSaveUserName.setOnClickListener {
            var text = binding.etSaveUserName.text.toString()
            var param = SaveUserNameParam(text)
            val result = saveUserNameParam.execute(param = param)
            binding.txUserName.text = "Save user = $result"
        }
    }
}