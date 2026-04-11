package com.example.pujroutefinder.updateprofile

import com.example.pujroutefinder.utils.SessionManager

class UpdateProfilePresenter(
    private var view: UpdateProfileContract.View?,
    private val sessionManager: SessionManager,
    private val repository: UpdateProfileRepository = UpdateProfileRepository()
) : UpdateProfileContract.Presenter {

    override fun updateProfile(fullName: String, username: String) {
        if (fullName.isEmpty() || username.isEmpty()) {
            view?.onUpdateError("All fields are required")
            return
        }

        view?.showLoading()

        repository.updateProfile(
            token = sessionManager.getToken(),
            userId = sessionManager.getUserId(),
            fullName = fullName,
            username = username,
            onSuccess = {
                view?.hideLoading()
                view?.onUpdateSuccess()
            },
            onError = { message ->
                view?.hideLoading()
                view?.onUpdateError(message)
            }
        )
    }

    override fun onDestroy() {
        view = null
    }
}