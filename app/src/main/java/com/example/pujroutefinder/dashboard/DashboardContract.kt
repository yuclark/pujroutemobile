package com.example.pujroutefinder.dashboard

import com.example.pujroutefinder.model.Route

interface DashboardContract {

    interface View {
        fun navigateToProfile()
        fun showRoutes(routes: List<Route>, title: String)
        fun showEmptyResults(title: String)
        fun setSearchCardVisibility(visible: Boolean)
    }

    interface Presenter {
        fun onNavItemSelected(itemId: Int)
        fun onSearchClicked(from: String, to: String)
        fun onFavoriteClicked(route: Route)
        fun loadInitialRoutes()
        fun onDestroy()
    }
}