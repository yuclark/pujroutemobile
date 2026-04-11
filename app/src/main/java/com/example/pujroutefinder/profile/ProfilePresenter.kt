package com.example.pujroutefinder.profile

import com.example.pujroutefinder.R
import com.example.pujroutefinder.utils.SessionManager

class ProfilePresenter(
    private var view: ProfileContract.View?,
    private val sessionManager: SessionManager,
    private val repository: ProfileRepository = ProfileRepository()
) : ProfileContract.Presenter {

    override fun loadProfile() {
        view?.showLoading()

        repository.getProfile(
            token = sessionManager.getToken(),
            userIdFilter = "eq.${sessionManager.getUserId()}",
            onSuccess = { profiles ->
                view?.hideLoading()
                val fullName = if (profiles.isNotEmpty()) {
                    profiles[0].full_name ?: "No name set"
                } else {
                    "No name set"
                }
                view?.onProfileLoaded(fullName, sessionManager.getEmail())
            },
            onError = {
                view?.hideLoading()
                view?.onProfileError(sessionManager.getEmail())
            }
        )
    }

    override fun onLogout() {
        sessionManager.clearSession()
        view?.navigateToLogin()
    }

    override fun onNavItemSelected(itemId: Int) {
        when (itemId) {
            R.id.nav_home -> view?.navigateToDashboard()
        }
    }

    override fun onDestroy() {
        view = null
    }
}