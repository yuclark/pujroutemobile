package com.example.pujroutefinder.dashboard

interface DashboardContract {

    interface View {
        fun navigateToProfile()
        fun showSearchComingSoon()
    }

    interface Presenter {
        fun onNavItemSelected(itemId: Int)
        fun onSearchClicked()
        fun onDestroy()
    }
}