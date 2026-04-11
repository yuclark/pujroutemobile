package com.example.pujroutefinder.updateprofile

import com.example.pujroutefinder.model.ProfileResponse
import com.example.pujroutefinder.model.UpdateProfileRequest
import com.example.pujroutefinder.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateProfileRepository {

    fun updateProfile(
        token: String,
        userId: String,
        fullName: String,
        username: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        RetrofitClient.instance.updateProfile(
            token = token,
            prefer = "return=representation",
            id = "eq.$userId",
            request = UpdateProfileRequest(fullName, username)
        ).enqueue(object : Callback<List<ProfileResponse>> {
            override fun onResponse(
                call: Call<List<ProfileResponse>>,
                response: Response<List<ProfileResponse>>
            ) {
                when (response.code()) {
                    200 -> onSuccess()
                    401 -> onError("Unauthorized")
                    500 -> onError("Server error")
                    else -> onError("Failed: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ProfileResponse>>, t: Throwable) {
                onError("No internet connection")
            }
        })
    }
}