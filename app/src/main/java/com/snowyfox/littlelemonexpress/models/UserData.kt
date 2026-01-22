package com.snowyfox.littlelemonexpress.models

data class UserData(
    var firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val isLoggedIn: Boolean = false,
)
