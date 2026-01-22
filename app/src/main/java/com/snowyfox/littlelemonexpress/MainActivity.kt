package com.snowyfox.littlelemonexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.snowyfox.littlelemonexpress.ui.navigation.LittleLemonNavigation
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.screens.HomeScreen
import com.snowyfox.littlelemonexpress.ui.theme.LittleLemonExpressTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LittleLemonExpressTheme {
                HomeScreen()
            }
        }
    }
}
private fun getStartDestination(profilePresent: Boolean): Screens {
    return when(profilePresent){
        true -> Screens.HomeScreen
        false -> Screens.ProfileScreen
    }
}

