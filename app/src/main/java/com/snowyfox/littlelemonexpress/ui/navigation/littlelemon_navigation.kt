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
import com.snowyfox.littlelemonexpress.ui.viewmodels.OnboardingViewModel

@Composable
fun LittleLemonNavigation(
    startDestination: Screens,
    navController: NavHostController,
    viewModel: OnboardingViewModel
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        onBoardingRoute(navController, viewModel)
        homeScreen(navController)
        profileScreen(navController, viewModel)
    }

}

fun NavGraphBuilder.onBoardingRoute(navController: NavHostController, viewModel: OnboardingViewModel) {
    composable<Screens.OnBoardingScreen> {
        OnBoardingScreen(navController, viewModel )
    }
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable<Screens.HomeScreen> {
        HomeScreen(navController)
    }
}

fun NavGraphBuilder.profileScreen(naveController: NavHostController,viewModel: OnboardingViewModel) {
    composable<Screens.ProfileScreen> {
        ProfileScreen(naveController, viewModel)
    }
}