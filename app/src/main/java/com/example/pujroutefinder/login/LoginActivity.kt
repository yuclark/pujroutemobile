package com.example.pujroutefinder.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pujroutefinder.R
import com.example.pujroutefinder.dashboard.DashboardActivity
import com.example.pujroutefinder.register.RegisterActivity
import com.example.pujroutefinder.utils.SessionManager

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvRegister: TextView

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sessionManager = SessionManager(this)
        presenter = LoginPresenter(this, sessionManager)

        if (sessionManager.isLoggedIn()) {
            goToDashboard()
            return
        }

        etEmail     = findViewById(R.id.etEmail)
        etPassword  = findViewById(R.id.etPassword)
        btnLogin    = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)
        tvRegister  = findViewById(R.id.tvRegister)

        btnLogin.setOnClickListener {
            presenter.login(
                etEmail.text.toString().trim(),
                etPassword.text.toString().trim()
            )
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // ── LoginContract.View ──────────────────────────────

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        btnLogin.isEnabled = false
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
        btnLogin.isEnabled = true
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
        goToDashboard()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // ── Helpers ─────────────────────────────────────────

    private fun goToDashboard() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}