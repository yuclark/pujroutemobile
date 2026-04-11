package com.example.pujroutefinder.profile

interface ProfileContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun onProfileLoaded(fullName: String, email: String)
        fun onProfileError(email: String)
        fun navigateToDashboard()
        fun navigateToUpdateProfile()
        fun navigateToChangePassword()
        fun navigateToLogin()
        fun showPhotoComingSoon()
    }

    interface Presenter {
        fun loadProfile()
        fun onLogout()
        fun onNavItemSelected(itemId: Int)
        fun onDestroy()
    }
}