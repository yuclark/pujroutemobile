package com.example.pujroutefinder.model

data class Route(
    val routeNumber: String,
    val name: String,
    val description: String,
    val terminals: List<String>,
    val stops: List<Stop>,
    val fareEstimate: FareEstimate,
    val tips: List<String>,
    var isFavorite: Boolean = false,
    var isExpanded: Boolean = false
)

data class Stop(
    val name: String,
    val type: String
)

data class FareEstimate(
    val baseFare: Int,
    val baseKm: Int,
    val note: String
)