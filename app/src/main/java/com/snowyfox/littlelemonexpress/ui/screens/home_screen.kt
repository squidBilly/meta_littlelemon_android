package com.snowyfox.littlelemonexpress.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snowyfox.littlelemonexpress.data.categories
import com.snowyfox.littlelemonexpress.data.menuItems
import com.snowyfox.littlelemonexpress.ui.components.DishButton
import com.snowyfox.littlelemonexpress.ui.components.DishMenuCard
import com.snowyfox.littlelemonexpress.ui.theme.ButtonYellow
import com.snowyfox.littlelemonexpress.ui.theme.DarkGreens
import com.snowyfox.littlelemonexpress.ui.theme.Grey50s

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Little Lemon") },
                navigationIcon = {
                    IconButton(
                        onClick = { /*Open Modal Drawer*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(top = 20.dp, start = 4.dp, end = 4.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = DarkGreens),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                ) {
                    Text(
                        text = "Little Lemon",
                        style = TextStyle(
                            fontSize = 48.sp,
                            fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                            fontWeight = FontWeight.Bold,
                            color = ButtonYellow,
                            lineHeight = 10.sp
                        ),
                        modifier = Modifier
                            .padding(top = 8.dp, start = 8.dp)
                            .align(Alignment.TopStart)
                    )
                    Text(
                        text = "Chicago",
                        style = TextStyle(
                            fontSize = 30.sp,
                            color = Color.White,
                            fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.BottomStart)
                    )
                }


                Box(
                    modifier = Modifier
                        .width(250.dp)
                        .height(150.dp)

                ) {
                    Text(
                        text = "We are a family owned mediterranean restaurant, focused on traditional recipes served with a modern twist",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(start = 10.dp, top = 12.dp)
                    )
                }
            }
            Text(
                text = "ORDER FOR DELIVERY!",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.padding(top = 30.dp, bottom = 8.dp, start = 10.dp)
            )
            LazyRow(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(items = categories) { dish ->
                    DishButton(dish)
                }
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = Grey50s.copy(alpha = .1f)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(items = menuItems, key = { menuItem -> menuItem.id }) { menuItem ->
                    DishMenuCard(
                        title = menuItem.title,
                        description = menuItem.description,
                        price = menuItem.price,
                        imageResId = menuItem.image,
                        onClick = {}
                    )
                }
            }
        }
    }
}