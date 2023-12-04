package com.example.cleanarchitecturekotlin.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
):ViewModel() {

    var resultLive = MutableLiveData<String>()
    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "VM cleared")
    }

    fun save(text: String){
        var param = com.example.domain.models.SaveUserNameParam(text)
        val resultData = saveUserNameUseCase.execute(param = param)
        resultLive.value=  "Save user = $resultData"

    }

    fun load(){
        var username = getUserNameUseCase.execute()
        resultLive.value = "${username.firstName} ${username.lastName}"

    }
}