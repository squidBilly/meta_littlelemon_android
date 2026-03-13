package com.snowyfox.littlelemonexpress.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
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
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        homeScreen(
            navController = navController,
        )
        onBoardingRoute(
            navController = navController,
            viewModel = mainViewModel,
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screens.HomeScreen)
            }
        )
        profileScreen(navController)
    }
}

fun NavGraphBuilder.onBoardingRoute(
    navController: NavController,
    viewModel: MainViewModel,
    navigateToHome: () -> Unit
) {
    composable<Screens.OnBoardingScreen> {
        OnBoardingScreen(navController, viewModel,navigateToHome = navigateToHome)
    }
}

fun NavGraphBuilder.homeScreen(
    navController: NavController
) {
    composable<Screens.HomeScreen> {
        HomeScreen(navController)
    }
}

fun NavGraphBuilder.profileScreen(
    naveController: NavController
) {
    composable<Screens.ProfileScreen>(exitTransition = {
        fadeOut(animationSpec = tween(durationMillis = 300, delayMillis = 200))
    }

    ) {
        val viewModel: ProfileViewModel = koinViewModel()
        ProfileScreen(naveController, viewModel)
    }
}