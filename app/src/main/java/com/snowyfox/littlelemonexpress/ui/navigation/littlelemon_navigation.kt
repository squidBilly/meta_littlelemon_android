package com.snowyfox.littlelemonexpress.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.snowyfox.littlelemonexpress.models.UserDataState
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.screens.HomeScreen
import com.snowyfox.littlelemonexpress.ui.screens.OnBoardingScreen
import com.snowyfox.littlelemonexpress.ui.screens.ProfileScreen
import com.snowyfox.littlelemonexpress.ui.viewmodels.MainViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LittleLemonNavigation(
    startDestination: Screens,
    navController: NavHostController,
) {
    val viewModel = koinViewModel<MainViewModel>()
    val state by viewModel.state.collectAsState()
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        onBoardingRoute(navController, state, viewModel)
        homeScreen(navController)
        profileScreen(navController,state, viewModel)
    }

}

fun NavGraphBuilder.onBoardingRoute(
    navController: NavHostController,
    state: UserDataState,
    viewModel: MainViewModel
) {
    composable<Screens.OnBoardingScreen> {
        OnBoardingScreen(navController, state, viewModel::onEvent)
    }
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable<Screens.HomeScreen> {
        HomeScreen(navController)
    }
}

fun NavGraphBuilder.profileScreen(
    naveController: NavHostController,
    state: UserDataState,
    viewModel: MainViewModel
) {
    composable<Screens.ProfileScreen> {
        ProfileScreen(naveController,state, viewModel::onEvent)
    }
}