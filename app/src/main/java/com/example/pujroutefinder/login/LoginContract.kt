package com.example.pujroutefinder.login

interface LoginContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun onLoginSuccess()
        fun onLoginError(message: String)
    }

    interface Presenter {
        fun login(email: String, password: String)
        fun onDestroy()
    }
}