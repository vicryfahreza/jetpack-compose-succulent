package com.vicryfahreza.succulentapp.ui.navigation

sealed class Page(val route: String) {
    object Dashboard : Page("dashboard")
    object Info : Page("info")
    object About : Page("about")
    object DetailSucculent : Page("dashboard/{succulentId}") {
        fun createRoute(succulentId: Long) = "dashboard/$succulentId"
    }
}