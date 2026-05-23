package com.example.pujroutefinder.dashboard

import com.example.pujroutefinder.R

import com.example.pujroutefinder.model.Route
import com.example.pujroutefinder.utils.RouteDataSource

class DashboardPresenter(
    private var view: DashboardContract.View?
) : DashboardContract.Presenter {

    private val allRoutes = RouteDataSource.getRoutes().toMutableList()

    override fun onNavItemSelected(itemId: Int) {
        when (itemId) {
            R.id.nav_home -> {
                view?.setSearchCardVisibility(true)
                view?.showRoutes(allRoutes, "📈 Popular Routes")
            }
            R.id.nav_puj_list -> {
                view?.setSearchCardVisibility(false)
                view?.showRoutes(allRoutes, "🚌 All PUJ Routes")
            }
            R.id.nav_favorites -> {
                view?.setSearchCardVisibility(false)
                val favorites = allRoutes.filter { it.isFavorite }
                if (favorites.isEmpty()) {
                    view?.showEmptyResults("No Favorites Yet")
                } else {
                    view?.showRoutes(favorites, "❤️ Your Favorites")
                }
            }
            R.id.nav_settings -> view?.navigateToProfile()
        }
    }

    override fun onSearchClicked(from: String, to: String) {
        if (from.isEmpty() && to.isEmpty()) {
            view?.showRoutes(allRoutes, "📈 Popular Routes")
            return
        }

        val filteredRoutes = allRoutes.filter { route ->
            val fromIndex = route.stops.indexOfFirst { it.name.equals(from, ignoreCase = true) }
            val toIndex = route.stops.indexOfFirst { it.name.equals(to, ignoreCase = true) }

            if (from.isNotEmpty() && to.isNotEmpty()) {
                fromIndex != -1 && toIndex != -1 && fromIndex < toIndex
            } else if (from.isNotEmpty()) {
                fromIndex != -1
            } else {
                toIndex != -1
            }
        }

        if (filteredRoutes.isEmpty()) {
            view?.showEmptyResults("No routes found for this search")
        } else {
            view?.showRoutes(filteredRoutes, "🔍 Search Results")
        }
    }

    override fun onFavoriteClicked(route: Route) {
        route.isFavorite = !route.isFavorite
        // If we are in favorites tab, we might want to refresh to hide if unfavorited
        // However, the user is likely in PUJ list or Home when they click it too.
        // For simplicity, let's keep it as is, the view will call notifyDataSetChanged()
    }

    override fun loadInitialRoutes() {
        view?.setSearchCardVisibility(true)
        view?.showRoutes(allRoutes, "📈 Popular Routes")
    }

    override fun onDestroy() {
        view = null
    }
}