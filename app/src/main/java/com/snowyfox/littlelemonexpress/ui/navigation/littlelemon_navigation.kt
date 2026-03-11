package com.snowyfox.littlelemonexpress.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.screens.HomeScreen
import com.snowyfox.littlelemonexpress.ui.screens.OnBoardingScreen
import com.snowyfox.littlelemonexpress.ui.screens.ProfileScreen
import com.snowyfox.littlelemonexpress.ui.viewmodels.MainViewModel
import com.snowyfox.littlelemonexpress.ui.viewmodels.ProfileViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun LittleLemonNavigation(
    startDestination: Screens,
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val profileViewModel: ProfileViewModel = koinViewModel()
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        homeScreen(navController)
        onBoardingRoute(navController, mainViewModel)
        profileScreen(navController, profileViewModel)
    }
}

fun NavGraphBuilder.onBoardingRoute(
    navController: NavController,
    viewModel: MainViewModel,
) {
    composable<Screens.OnBoardingScreen>(
    ) {
        OnBoardingScreen(navController, viewModel)
    }
}

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<Screens.HomeScreen>(
    ) {
        HomeScreen(navController)
    }
}

fun NavGraphBuilder.profileScreen(
    naveController: NavController,
    viewModel: ProfileViewModel,
) {
    composable<Screens.ProfileScreen>(exitTransition = {
        fadeOut(animationSpec = tween(durationMillis = 300, delayMillis = 200))
    }
    ) {
        ProfileScreen(naveController, viewModel)
    }
}