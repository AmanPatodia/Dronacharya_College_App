package com.example.dronacharya_college_app.navigation

sealed class Routes(val route : String) {

    object Home : Routes(route = "home")
    object AboutUs : Routes(route = "about_us")
    object Gallery : Routes(route = "gallery")
    object Faculty : Routes(route = "faculty")
    object BottomNav : Routes(route = "bottom_nav")
    object AdminDashboard : Routes(route = "admin_dashboard")
}