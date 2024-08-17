package com.example.dronacharya_college_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dronacharya_college_app.admin.screens.AdminDashboard
import com.example.dronacharya_college_app.screens.AboutUs
import com.example.dronacharya_college_app.screens.BottomNav
import com.example.dronacharya_college_app.screens.Faculty
import com.example.dronacharya_college_app.screens.Gallery
import com.example.dronacharya_college_app.screens.Home

@Composable
fun NavGraph(navController : NavHostController) {

    val isAdmin = false

    NavHost(
        navController = navController,
        startDestination = if(isAdmin) Routes.AdminDashboard.route else Routes.BottomNav.route
    ){

        composable(Routes.BottomNav.route){
            BottomNav()
        }

        composable(Routes.Home.route){
            Home()
        }

        composable(Routes.Gallery.route){
            Gallery()
        }

        composable(Routes.AboutUs.route){
            AboutUs()
        }

        composable(Routes.Faculty.route){
            Faculty()
        }

        composable(Routes.AdminDashboard.route){
            AdminDashboard(navController)
        }
    }

}