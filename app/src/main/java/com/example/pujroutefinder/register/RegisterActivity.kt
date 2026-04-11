package com.example.pujroutefinder.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pujroutefinder.R
import com.example.pujroutefinder.login.LoginActivity

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    private lateinit var etName: EditText
    private lateinit var etStudentId: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvLogin: TextView

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)

        etName      = findViewById(R.id.etName)
        etStudentId = findViewById(R.id.etStudentId)
        etEmail     = findViewById(R.id.etEmail)
        etPassword  = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)
        progressBar = findViewById(R.id.progressBar)
        tvLogin     = findViewById(R.id.tvLogin)

        btnRegister.setOnClickListener {
            presenter.register(
                etName.text.toString().trim(),
                etStudentId.text.toString().trim(),
                etEmail.text.toString().trim(),
                etPassword.text.toString().trim()
            )
        }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    // ── RegisterContract.View ───────────────────────────

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        btnRegister.isEnabled = false
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
        btnRegister.isEnabled = true
    }

    override fun onRegisterSuccess() {
        Toast.makeText(this, "Registered! Please sign in.", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onRegisterError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}