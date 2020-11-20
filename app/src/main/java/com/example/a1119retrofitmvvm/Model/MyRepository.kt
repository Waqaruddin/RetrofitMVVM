package com.example.a1119retrofitmvvm.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository {


    fun getUsers():LiveData<ArrayList<Users>>{
        val usersResponse = MutableLiveData<ArrayList<Users>>()

        MyApi().getUsers()
            .enqueue(object : Callback<UsersResponse>{
                override fun onResponse(
                    call: Call<UsersResponse>,
                    response: Response<UsersResponse>
                ) {
                    if(response.isSuccessful){
                        usersResponse.value = response.body()?.data
                    }
                }

                override fun onFailure(call: Call<UsersResponse>, t: Throwable) {

                }

            })
        return usersResponse

    }
}