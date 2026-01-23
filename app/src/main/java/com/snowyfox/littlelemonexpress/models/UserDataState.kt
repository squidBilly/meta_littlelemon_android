package com.snowyfox.littlelemonexpress.models

data class UserDataState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val isLoggedIn: Boolean = false,
)

data class UserData(
    val firstName: String,
    val lastName: String,
    val email: String,
    val isLoggedIn: Boolean,
)
