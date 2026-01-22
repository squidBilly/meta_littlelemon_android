package com.snowyfox.littlelemonexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.snowyfox.littlelemonexpress.ui.navigation.LittleLemonNavigation
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.theme.LittleLemonExpressTheme
import com.snowyfox.littlelemonexpress.ui.viewmodels.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: OnboardingViewModel = koinViewModel()
            viewModel.userData.collectAsState()
            LittleLemonExpressTheme {
                LittleLemonNavigation(Screens.HomeScreen, navController, viewModel)
            }
        }
    }
}

private fun getStartDestination(viewModel: OnboardingViewModel): Screens {
    val loggedIn = viewModel.userData.value.isLoggedIn
    return when (loggedIn) {
        true -> Screens.HomeScreen
        false -> Screens.OnBoardingScreen
    }
}

