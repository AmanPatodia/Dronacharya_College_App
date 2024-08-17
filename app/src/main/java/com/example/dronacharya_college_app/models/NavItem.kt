package com.example.dronacharya_college_app.models

data class NavItem(
    val title : String,
    val icon : Int
)

data class BottomNavItem(
    val title : String,
    val icon : Int,
    val route : String
)