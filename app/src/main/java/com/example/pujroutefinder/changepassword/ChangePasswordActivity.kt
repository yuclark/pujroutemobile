package com.example.pujroutefinder.changepassword

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pujroutefinder.R
import com.example.pujroutefinder.model.ChangePasswordRequest
import com.example.pujroutefinder.network.RetrofitClient
import com.example.pujroutefinder.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var etNewPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnChange: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvBack: TextView
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        sessionManager = SessionManager(this)

        etNewPassword = findViewById(R.id.etNewPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnChange = findViewById(R.id.btnChange)
        progressBar = findViewById(R.id.progressBar)
        tvBack = findViewById(R.id.tvBack)

        tvBack.setOnClickListener { finish() }
        btnChange.setOnClickListener { changePassword() }
    }

    private fun changePassword() {
        val newPassword = etNewPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }
        if (newPassword != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }
        if (newPassword.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            return
        }

        setLoading(true)

        RetrofitClient.instance.changePassword(
            token = sessionManager.getToken(),
            request = ChangePasswordRequest(newPassword)
        ).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                setLoading(false)
                when (response.code()) {
                    200 -> {
                        Toast.makeText(this@ChangePasswordActivity, "Password changed!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    401 -> Toast.makeText(this@ChangePasswordActivity, "Session expired. Please login again.", Toast.LENGTH_SHORT).show()
                    500 -> Toast.makeText(this@ChangePasswordActivity, "Server error", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this@ChangePasswordActivity, "Failed: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Any>, t: Throwable) {
                setLoading(false)
                Toast.makeText(this@ChangePasswordActivity, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setLoading(loading: Boolean) {
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        btnChange.isEnabled = !loading
    }
}