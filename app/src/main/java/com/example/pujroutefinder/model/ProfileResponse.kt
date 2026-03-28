package com.example.pujroutefinder.model

data class ProfileResponse(
    val id: String,
    val full_name: String?,
    val username: String?,
    val avatar_url: String?,
    val updated_at: String?
)