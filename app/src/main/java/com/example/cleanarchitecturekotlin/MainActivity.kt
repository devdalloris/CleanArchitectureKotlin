package com.example.cleanarchitecturekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecturekotlin.databinding.ActivityMainBinding
import com.example.cleanarchitecturekotlin.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekotlin.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekotlin.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var getUserNameUseCase = GetUserNameUseCase()
    private var saveUserNameParam = SaveUserNameUseCase()
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