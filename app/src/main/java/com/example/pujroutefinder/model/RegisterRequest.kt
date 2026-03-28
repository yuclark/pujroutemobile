package com.example.pujroutefinder.model

data class RegisterRequest(
    val email: String,
    val password: String,
    val data: UserMeta
)

data class UserMeta(
    val name: String,
    val studentId: String
)