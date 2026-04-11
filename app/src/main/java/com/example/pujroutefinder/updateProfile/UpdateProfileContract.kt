package com.example.pujroutefinder.updateprofile

interface UpdateProfileContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun onUpdateSuccess()
        fun onUpdateError(message: String)
    }

    interface Presenter {
        fun updateProfile(fullName: String, username: String)
        fun onDestroy()
    }
}