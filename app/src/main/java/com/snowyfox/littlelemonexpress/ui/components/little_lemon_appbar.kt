package com.snowyfox.littlelemonexpress.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.ShoppingBasket
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snowyfox.littlelemonexpress.ui.theme.DarkGreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LittleLemonAppBar(
    onNavigationIconClicked: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(com.snowyfox.littlelemonexpress.R.drawable.littlelemon_small),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
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
    LittleLemonAppBar {  }
}