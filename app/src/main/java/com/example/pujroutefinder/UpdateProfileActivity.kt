package com.example.pujroutefinder

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pujroutefinder.model.ProfileResponse
import com.example.pujroutefinder.model.UpdateProfileRequest
import com.example.pujroutefinder.network.RetrofitClient
import com.example.pujroutefinder.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateProfileActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etUsername: EditText
    private lateinit var btnSave: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvBack: TextView
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        sessionManager = SessionManager(this)

        etFullName = findViewById(R.id.etFullName)
        etUsername = findViewById(R.id.etUsername)
        btnSave = findViewById(R.id.btnSave)
        progressBar = findViewById(R.id.progressBar)
        tvBack = findViewById(R.id.tvBack)

        tvBack.setOnClickListener { finish() }
        btnSave.setOnClickListener { updateProfile() }
    }

    private fun updateProfile() {
        val fullName = etFullName.text.toString().trim()
        val username = etUsername.text.toString().trim()

        if (fullName.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }

        setLoading(true)

        RetrofitClient.instance.updateProfile(
            token = sessionManager.getToken(),
            prefer = "return=representation",
            id = "eq.${sessionManager.getUserId()}",
            request = UpdateProfileRequest(fullName, username)
        ).enqueue(object : Callback<List<ProfileResponse>> {
            override fun onResponse(call: Call<List<ProfileResponse>>, response: Response<List<ProfileResponse>>) {
                setLoading(false)
                when (response.code()) {
                    200 -> {
                        Toast.makeText(this@UpdateProfileActivity, "Profile updated!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    401 -> Toast.makeText(this@UpdateProfileActivity, "Unauthorized", Toast.LENGTH_SHORT).show()
                    500 -> Toast.makeText(this@UpdateProfileActivity, "Server error", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this@UpdateProfileActivity, "Failed: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<ProfileResponse>>, t: Throwable) {
                setLoading(false)
                Toast.makeText(this@UpdateProfileActivity, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setLoading(loading: Boolean) {
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        btnSave.isEnabled = !loading
    }
}