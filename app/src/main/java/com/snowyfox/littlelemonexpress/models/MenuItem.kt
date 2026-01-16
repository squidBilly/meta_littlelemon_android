package com.snowyfox.littlelemonexpress.models

import androidx.compose.ui.text.LinkAnnotation

data class MenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: Int,
    val category: Category
)
enum class Category {
    MAIN,
    STARTERS,
    DESSERTS
}
