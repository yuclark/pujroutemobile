package com.example.pujroutefinder.register

import com.example.pujroutefinder.model.RegisterRequest
import com.example.pujroutefinder.model.UserMeta
import com.example.pujroutefinder.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterRepository {

    fun register(
        email: String,
        password: String,
        name: String,
        studentId: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        RetrofitClient.instance.register(
            RegisterRequest(email, password, UserMeta(name, studentId))
        ).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                when (response.code()) {
                    200, 201 -> onSuccess()
                    400 -> onError("Email already registered")
                    500 -> onError("Server error. Try again.")
                    else -> onError("Failed: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                onError("No internet connection")
            }
        })
    }
}