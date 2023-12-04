package com.example.cleanarchitecturekotlin.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        vm.resultLive.observe(this) {
            binding.txUserName.text = it
        }
        binding.btnGetUserName.setOnClickListener {
            vm.load()
        }
        binding.btnSaveUserName.setOnClickListener {
            var text = binding.etSaveUserName.text.toString()
            vm.save(text)
        }
    }
}