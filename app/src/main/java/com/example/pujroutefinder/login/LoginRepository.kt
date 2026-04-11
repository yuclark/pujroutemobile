package com.example.pujroutefinder.login

import com.example.pujroutefinder.model.LoginRequest
import com.example.pujroutefinder.model.LoginResponse
import com.example.pujroutefinder.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    fun login(
        email: String,
        password: String,
        onSuccess: (LoginResponse) -> Unit,
        onError: (String) -> Unit
    ) {
        RetrofitClient.instance.login(LoginRequest(email, password))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    when (response.code()) {
                        200 -> onSuccess(response.body()!!)
                        400 -> onError("Invalid email or password")
                        401 -> onError("Unauthorized")
                        500 -> onError("Server error. Try again.")
                        else -> onError("Login failed: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    onError("No internet connection")
                }
            })
    }
}