package com.example.pujroutefinder.changepassword

import com.example.pujroutefinder.utils.SessionManager

class ChangePasswordPresenter(
    private var view: ChangePasswordContract.View?,
    private val sessionManager: SessionManager,
    private val repository: ChangePasswordRepository = ChangePasswordRepository()
) : ChangePasswordContract.Presenter {

    override fun changePassword(newPassword: String, confirmPassword: String) {
        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            view?.onChangeError("All fields are required")
            return
        }
        if (newPassword != confirmPassword) {
            view?.onChangeError("Passwords do not match")
            return
        }
        if (newPassword.length < 6) {
            view?.onChangeError("Password must be at least 6 characters")
            return
        }

        view?.showLoading()

        repository.changePassword(
            token = sessionManager.getToken(),
            newPassword = newPassword,
            onSuccess = {
                view?.hideLoading()
                view?.onChangeSuccess()
            },
            onError = { message ->
                view?.hideLoading()
                view?.onChangeError(message)
            }
        )
    }

    override fun onDestroy() {
        view = null
    }
}