package com.snowyfox.littlelemonexpress.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.snowyfox.littlelemonexpress.ui.navigation.screens.Screens
import com.snowyfox.littlelemonexpress.ui.theme.ButtonYellow
import com.snowyfox.littlelemonexpress.ui.theme.DarkGreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ProfileDrawer(
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    var selectedItem by remember { mutableStateOf<NavItem?>(null) }
    ModalDrawerSheet(
        modifier = Modifier.requiredWidth(300.dp),
        drawerShape = DrawerDefaults.shape
    ) {
        ProfileDrawerHeader()
        navItems.forEach { item ->
            NavigationDrawerItem(
                modifier = Modifier.background(color = Color.White)
                    .padding(NavigationDrawerItemDefaults.ItemPadding)
                ,
                icon = {
                    Icon(item.icon, contentDescription = item.contentDescription, tint = DarkGreens)
                },
                label = {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
                        )
                    )
                },
                selected = item == selectedItem,
                onClick = {
                    navController.navigate(Screens.ProfileScreen)
                    scope.launch { drawerState.close() }
                    selectedItem = item
                },
            )
        }
    }
}

@Composable
fun ProfileDrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 200.dp)
            .background(color = DarkGreens),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            "Profile",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                color = ButtonYellow
            )
        )
    }
}
