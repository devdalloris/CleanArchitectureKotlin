package com.example.cleanarchitecturekotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        com.example.data.repository.UserRepositoryImpl(
            userStorage = com.example.data.storage.sharedprefs.SharedPrefUserStorage(
                context = applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameParam by lazy(LazyThreadSafetyMode.NONE) {
        com.example.domain.usecase.SaveUserNameUseCase(
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
            var param = com.example.domain.models.SaveUserNameParam(text)
            val result = saveUserNameParam.execute(param = param)
            binding.txUserName.text = "Save user = $result"
        }
    }
}