package com.example.pujroutefinder.network

import com.example.pujroutefinder.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("auth/v1/signup")
    fun register(@Body request: RegisterRequest): Call<Any>

    @POST("auth/v1/token?grant_type=password")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("rest/v1/profiles")
    fun getProfile(
        @Header("Authorization") token: String,
        @Query("id") id: String
    ): Call<List<ProfileResponse>>

    @PATCH("rest/v1/profiles")
    fun updateProfile(
        @Header("Authorization") token: String,
        @Header("Prefer") prefer: String,
        @Query("id") id: String,
        @Body request: UpdateProfileRequest
    ): Call<List<ProfileResponse>>

    @PUT("auth/v1/user")
    fun changePassword(
        @Header("Authorization") token: String,
        @Body request: ChangePasswordRequest
    ): Call<Any>
}