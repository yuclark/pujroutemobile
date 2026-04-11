package com.example.pujroutefinder.login

import com.example.pujroutefinder.utils.SessionManager

class LoginPresenter(
    private var view: LoginContract.View?,
    private val sessionManager: SessionManager,
    private val repository: LoginRepository = LoginRepository()
) : LoginContract.Presenter {

    override fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            view?.onLoginError("Email and password are required")
            return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.onLoginError("Please enter a valid email")
            return
        }

        view?.showLoading()

        repository.login(
            email = email,
            password = password,
            onSuccess = { response ->
                sessionManager.saveSession(
                    response.access_token,
                    response.user.id,
                    response.user.email
                )
                view?.hideLoading()
                view?.onLoginSuccess()
            },
            onError = { message ->
                view?.hideLoading()
                view?.onLoginError(message)
            }
        )
    }

    override fun onDestroy() {
        view = null
    }
}