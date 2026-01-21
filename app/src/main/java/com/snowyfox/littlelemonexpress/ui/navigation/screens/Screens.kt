package com.snowyfox.littlelemonexpress.ui.navigation.screens

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens {
    @Serializable
    data object OnBoardingScreen : Screens

    @Serializable
    data object HomeScreen : Screens

    @Serializable
    data object ProfileScreen : Screens
}