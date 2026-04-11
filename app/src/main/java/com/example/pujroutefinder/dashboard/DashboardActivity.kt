package com.example.pujroutefinder.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.pujroutefinder.utils.SessionManager
import android.widget.Toast
import com.example.pujroutefinder.profile.ProfileActivity
import com.example.pujroutefinder.R

class DashboardActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sessionManager = SessionManager(this)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_settings -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> true
            }
        }

        findViewById<Button>(R.id.btnSearch).setOnClickListener {
            Toast.makeText(this, "Search coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}