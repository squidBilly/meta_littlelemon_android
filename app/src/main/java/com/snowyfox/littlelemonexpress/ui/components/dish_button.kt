package com.snowyfox.littlelemonexpress.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DishButton(dishName: String) {
    Column {
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(color = MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Text(text = dishName)
        }
    }
}

@Preview
@Composable
fun DishButtonPreview() {
    DishButton("Dinner")
}