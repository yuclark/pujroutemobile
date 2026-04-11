package com.example.pujroutefinder.changepassword

interface ChangePasswordContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun onChangeSuccess()
        fun onChangeError(message: String)
    }

    interface Presenter {
        fun changePassword(newPassword: String, confirmPassword: String)
        fun onDestroy()
    }
}