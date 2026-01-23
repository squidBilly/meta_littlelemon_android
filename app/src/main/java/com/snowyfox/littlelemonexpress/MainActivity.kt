package com.snowyfox.littlelemonexpress

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.snowyfox.littlelemonexpress.models.UserData
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
            val uiState by viewModel.userData.collectAsState()
            LittleLemonExpressTheme {
                LittleLemonNavigation(getStartDestination(uiState, this), navController, viewModel)
            }
        }
    }
}

private fun getStartDestination(uiState: UserData, context: Context): Screens {
    val loggedIn = uiState.isLoggedIn
    Toast.makeText(context, "$loggedIn", Toast.LENGTH_LONG).show()
    return when (loggedIn) {
        true -> Screens.HomeScreen
        false -> Screens.OnBoardingScreen
    }
}

