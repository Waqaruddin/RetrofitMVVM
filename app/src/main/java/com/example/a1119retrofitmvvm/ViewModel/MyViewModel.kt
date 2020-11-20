package com.example.a1119retrofitmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a1119retrofitmvvm.Model.MyRepository
import com.example.a1119retrofitmvvm.Model.Users


class MyViewModel : ViewModel(){

    fun getUsers(): LiveData<ArrayList<Users>> {
        val usersResponse = MyRepository().getUsers()
        return usersResponse
    }
}