package com.example.pujroutefinder.register

interface RegisterContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun onRegisterSuccess()
        fun onRegisterError(message: String)
    }

    interface Presenter {
        fun register(name: String, studentId: String, email: String, password: String)
        fun onDestroy()
    }
}