package com.example.pujroutefinder.model

data class LoginResponse(
    val access_token: String,
    val token_type: String,
    val user: UserData
)

data class UserData(
    val id: String,
    val email: String
)