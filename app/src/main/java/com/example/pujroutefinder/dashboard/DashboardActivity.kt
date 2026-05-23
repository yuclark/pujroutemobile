package com.example.pujroutefinder.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pujroutefinder.R
import com.example.pujroutefinder.model.Route
import com.example.pujroutefinder.profile.ProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity(), DashboardContract.View {

    private lateinit var presenter: DashboardContract.Presenter
    private lateinit var routeAdapter: RouteAdapter

    private lateinit var etFrom: EditText
    private lateinit var etTo: EditText
    private lateinit var tvResultsTitle: TextView
    private lateinit var searchCardContainer: android.view.View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        presenter = DashboardPresenter(this)

        etFrom = findViewById(R.id.etFrom)
        etTo = findViewById(R.id.etTo)
        tvResultsTitle = findViewById(R.id.tvResultsTitle)
        searchCardContainer = findViewById(R.id.searchCardContainer)

        setupRecyclerView()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener { item ->
            presenter.onNavItemSelected(item.itemId)
            true
        }

        findViewById<Button>(R.id.btnSearch).setOnClickListener {
            val from = etFrom.text.toString().trim()
            val to = etTo.text.toString().trim()
            presenter.onSearchClicked(from, to)
        }

        presenter.loadInitialRoutes()
    }

    private fun setupRecyclerView() {
        val rvRoutes = findViewById<RecyclerView>(R.id.rvRoutes)
        routeAdapter = RouteAdapter(emptyList()) { route ->
            presenter.onFavoriteClicked(route)
            routeAdapter.notifyDataSetChanged()
        }
        rvRoutes.layoutManager = LinearLayoutManager(this)
        rvRoutes.adapter = routeAdapter
        rvRoutes.setHasFixedSize(true)
    }

    override fun navigateToProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    override fun showRoutes(routes: List<Route>, title: String) {
        tvResultsTitle.text = title
        routeAdapter.updateRoutes(routes)
    }

    override fun showEmptyResults(title: String) {
        tvResultsTitle.text = title
        routeAdapter.updateRoutes(emptyList())
    }

    override fun setSearchCardVisibility(visible: Boolean) {
        searchCardContainer.visibility = if (visible) android.view.View.VISIBLE else android.view.View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}