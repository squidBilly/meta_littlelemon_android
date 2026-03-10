package com.snowyfox.littlelemonexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.snowyfox.littlelemonexpress.ui.navigation.LittleLemonNavigation
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.theme.LittleLemonExpressTheme
import com.snowyfox.littlelemonexpress.ui.viewmodels.LoginViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonExpressTheme {
                val loginViewModel: LoginViewModel = koinViewModel()
                val logInState by loginViewModel.logInState.collectAsState()
                val navController = rememberNavController()
                LittleLemonNavigation(getStartScreen(logInState), navController)
            }
        }
    }
}

private fun getStartScreen(logInState: Boolean): Screens {
    return when (logInState) {
        true -> Screens.HomeScreen
        false -> Screens.OnBoardingScreen
    }

}



