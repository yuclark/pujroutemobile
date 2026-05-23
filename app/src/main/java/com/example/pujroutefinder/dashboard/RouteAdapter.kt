package com.example.pujroutefinder.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pujroutefinder.R
import com.example.pujroutefinder.model.Route

class RouteAdapter(
    private var routes: List<Route>,
    private val onFavoriteClick: (Route) -> Unit
) : RecyclerView.Adapter<RouteAdapter.RouteViewHolder>() {

    fun updateRoutes(newRoutes: List<Route>) {
        routes = newRoutes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_route, parent, false)
        return RouteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val route = routes[position]
        holder.bind(route)
    }

    override fun getItemCount(): Int = routes.size

    inner class RouteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvRouteNumber: TextView = itemView.findViewById(R.id.tvRouteNumber)
        private val tvRouteName: TextView = itemView.findViewById(R.id.tvRouteName)
        private val tvTerminals: TextView = itemView.findViewById(R.id.tvTerminals)
        private val ivFavorite: ImageView = itemView.findViewById(R.id.ivFavorite)
        private val detailsContainer: LinearLayout = itemView.findViewById(R.id.detailsContainer)
        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        private val tvFullStops: TextView = itemView.findViewById(R.id.tvFullStops)
        private val tvFare: TextView = itemView.findViewById(R.id.tvFare)

        fun bind(route: Route) {
            tvRouteNumber.text = route.routeNumber
            tvRouteName.text = route.name
            tvTerminals.text = route.terminals.joinToString(" ↔ ")
            
            val favIcon = if (route.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
            ivFavorite.setImageResource(favIcon)

            ivFavorite.setOnClickListener {
                onFavoriteClick(route)
            }

            // Expanded state
            detailsContainer.visibility = if (route.isExpanded) View.VISIBLE else View.GONE
            if (route.isExpanded) {
                tvDescription.text = route.description
                tvFullStops.text = route.stops.joinToString("\n") { "• ${it.name} (${it.type})" }
                tvFare.text = route.fareEstimate.note
            }

            itemView.setOnClickListener {
                route.isExpanded = !route.isExpanded
                notifyItemChanged(adapterPosition)
            }
        }
    }
}