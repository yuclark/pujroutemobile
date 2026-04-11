package com.example.pujroutefinder.changepassword

import com.example.pujroutefinder.model.ChangePasswordRequest
import com.example.pujroutefinder.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordRepository {

    fun changePassword(
        token: String,
        newPassword: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        RetrofitClient.instance.changePassword(
            token = token,
            request = ChangePasswordRequest(newPassword)
        ).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                when (response.code()) {
                    200 -> onSuccess()
                    401 -> onError("Session expired. Please login again.")
                    500 -> onError("Server error")
                    else -> onError("Failed: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                onError("No internet connection")
            }
        })
    }
}