package com.example.pujroutefinder.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pujroutefinder.changepassword.ChangePasswordActivity
import com.example.pujroutefinder.R
import com.example.pujroutefinder.updateprofile.UpdateProfileActivity
import com.example.pujroutefinder.dashboard.DashboardActivity
import com.example.pujroutefinder.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.pujroutefinder.model.ProfileResponse
import com.example.pujroutefinder.network.RetrofitClient
import com.example.pujroutefinder.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvFullName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvStudentId: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sessionManager = SessionManager(this)

        tvFullName = findViewById(R.id.tvFullName)
        tvEmail = findViewById(R.id.tvEmail)
        tvStudentId = findViewById(R.id.tvStudentId)
        progressBar = findViewById(R.id.progressBar)

        tvEmail.text = sessionManager.getEmail()
        loadProfile()

        findViewById<Button>(R.id.btnUpdateProfile).setOnClickListener {
            startActivity(Intent(this, UpdateProfileActivity::class.java))
        }
        findViewById<Button>(R.id.btnChangePassword).setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            sessionManager.clearSession()
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }
        findViewById<Button>(R.id.btnChangePhoto).setOnClickListener {
            Toast.makeText(this, "Photo upload coming soon!", Toast.LENGTH_SHORT).show()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_settings
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, DashboardActivity::class.java))
                    true
                }
                else -> true
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadProfile()
    }

    private fun loadProfile() {
        progressBar.visibility = View.VISIBLE
        RetrofitClient.instance.getProfile(
            sessionManager.getToken(),
            "eq.${sessionManager.getUserId()}"
        ).enqueue(object : Callback<List<ProfileResponse>> {
            override fun onResponse(call: Call<List<ProfileResponse>>, response: Response<List<ProfileResponse>>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val profile = response.body()
                    if (!profile.isNullOrEmpty()) {
                        tvFullName.text = profile[0].full_name ?: "No name set"
                    } else {
                        tvFullName.text = "No name set"
                    }
                    tvEmail.text = sessionManager.getEmail()
                } else {
                    tvFullName.text = "No name set"
                    tvEmail.text = sessionManager.getEmail()
                }
            }
            override fun onFailure(call: Call<List<ProfileResponse>>, t: Throwable) {
                progressBar.visibility = View.GONE
                tvFullName.text = "No name set"
                tvEmail.text = sessionManager.getEmail()
            }
        })
    }
}