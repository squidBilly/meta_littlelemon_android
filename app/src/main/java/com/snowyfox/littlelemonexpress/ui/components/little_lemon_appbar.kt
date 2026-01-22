package com.snowyfox.littlelemonexpress.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.ShoppingBasket
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.snowyfox.littlelemonexpress.ui.theme.DarkGreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LittleLemonAppBar(
    onNavigationIconClicked: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Little Lemon", style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                    fontWeight = FontWeight.Bold,
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = DarkGreens
        ),
        navigationIcon = {
            IconButton(onClick = { onNavigationIconClicked() }) {
                Icon(
                    Icons.Default.Menu,
                    "Toggle Navigation Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Rounded.ShoppingBasket,
                    contentDescription = "Shopping basket",
                    tint = DarkGreens
                )
            }
        }
    )
}

@Composable
@Preview
fun LittleLemonAppBarLogo() {
    LittleLemonAppBar { }
}