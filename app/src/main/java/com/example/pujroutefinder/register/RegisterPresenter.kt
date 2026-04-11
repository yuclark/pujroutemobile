package com.example.pujroutefinder.register

class RegisterPresenter(
    private var view: RegisterContract.View?,
    private val repository: RegisterRepository = RegisterRepository()
) : RegisterContract.Presenter {

    override fun register(name: String, studentId: String, email: String, password: String) {
        if (name.isEmpty() || studentId.isEmpty() || email.isEmpty() || password.isEmpty()) {
            view?.onRegisterError("All fields are required")
            return
        }
        if (password.length < 6) {
            view?.onRegisterError("Password must be at least 6 characters")
            return
        }

        view?.showLoading()

        repository.register(
            email = email,
            password = password,
            name = name,
            studentId = studentId,
            onSuccess = {
                view?.hideLoading()
                view?.onRegisterSuccess()
            },
            onError = { message ->
                view?.hideLoading()
                view?.onRegisterError(message)
            }
        )
    }

    override fun onDestroy() {
        view = null
    }
}