package com.snowyfox.littlelemonexpress.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val id: String,
    val contentDescription: String,
    val title: String,
    val icon: ImageVector
)
val navItems = listOf(
    NavItem("profile","profile route","Profile",Icons.Rounded.Person2)
)