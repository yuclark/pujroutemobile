package com.example.pujroutefinder.dashboard

import com.example.pujroutefinder.R

class DashboardPresenter(
    private var view: DashboardContract.View?
) : DashboardContract.Presenter {

    override fun onNavItemSelected(itemId: Int) {
        when (itemId) {
            R.id.nav_settings -> view?.navigateToProfile()
        }
    }

    override fun onSearchClicked() {
        view?.showSearchComingSoon()
    }

    override fun onDestroy() {
        view = null
    }
}