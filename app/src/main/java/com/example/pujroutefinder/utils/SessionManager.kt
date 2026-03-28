package com.example.pujroutefinder.utils

import android.content.Context

class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("PUJ_SESSION", Context.MODE_PRIVATE)

    fun saveSession(token: String, userId: String, email: String) {
        prefs.edit()
            .putString("TOKEN", token)
            .putString("USER_ID", userId)
            .putString("EMAIL", email)
            .apply()
    }

    fun getToken(): String = "Bearer ${prefs.getString("TOKEN", "")}"
    fun getUserId(): String = prefs.getString("USER_ID", "") ?: ""
    fun getEmail(): String = prefs.getString("EMAIL", "") ?: ""
    fun isLoggedIn(): Boolean = prefs.getString("TOKEN", null) != null
    fun clearSession() = prefs.edit().clear().apply()
}