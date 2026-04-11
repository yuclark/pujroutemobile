package com.example.pujroutefinder.profile

import com.example.pujroutefinder.model.ProfileResponse
import com.example.pujroutefinder.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileRepository {

    fun getProfile(
        token: String,
        userIdFilter: String,
        onSuccess: (List<ProfileResponse>) -> Unit,
        onError: () -> Unit
    ) {
        RetrofitClient.instance.getProfile(token, userIdFilter)
            .enqueue(object : Callback<List<ProfileResponse>> {
                override fun onResponse(
                    call: Call<List<ProfileResponse>>,
                    response: Response<List<ProfileResponse>>
                ) {
                    if (response.isSuccessful) {
                        onSuccess(response.body() ?: emptyList())
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<List<ProfileResponse>>, t: Throwable) {
                    onError()
                }
            })
    }
}