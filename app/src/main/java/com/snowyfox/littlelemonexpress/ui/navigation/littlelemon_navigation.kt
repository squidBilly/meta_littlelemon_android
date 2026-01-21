package com.snowyfox.littlelemonexpress.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.screens.HomeScreen
import com.snowyfox.littlelemonexpress.ui.screens.OnBoardingScreen
import com.snowyfox.littlelemonexpress.ui.screens.ProfileScreen

@Composable
fun LittleLemonNavigation(
    startDestination: Screens,
    navController: NavHostController,
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        onBoardingRoute()
        homeScreen()
        profileScreen()
    }

}

fun NavGraphBuilder.onBoardingRoute() {
    composable<Screens.OnBoardingScreen> {
        OnBoardingScreen()
    }
}

fun NavGraphBuilder.homeScreen() {
    composable<Screens.HomeScreen> {
        HomeScreen()
    }
}

fun NavGraphBuilder.profileScreen() {
    composable<Screens.ProfileScreen> {
        ProfileScreen()
    }
}