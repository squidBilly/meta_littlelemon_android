package com.snowyfox.littlelemonexpress.data

import com.snowyfox.littlelemonexpress.R
import com.snowyfox.littlelemonexpress.models.Category
import com.snowyfox.littlelemonexpress.models.MenuItem


val menuItems: List<MenuItem> = listOf(
    MenuItem(
        id = 1,
        title = "Greek Salad",
        description = "The famous greek salad of crispy lettuce, peppers, olives, our chicago",
        price = "10",
        image = R.drawable.tiny_greek_salad,
        category = Category.STARTERS
    ),
    MenuItem(
        id = 2,
        title = "Lemon Dessert",
        description = "Traditional homemade Italian Lemon Ricotta Cake",
        price = "10",
        image = R.drawable.biscoti_tomato,
        category = Category.DESSERTS
    ),
    MenuItem(
        id = 3,
        title = "Grilled Fish",
        description = "Whole grilled fish with Italian bread and vegetables",
        price = "10",
        image = R.drawable.grilled_fish,
        category = Category.MAIN
    ),
    MenuItem(
        id = 4,
        title = "Pasta",
        description = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chili, garlic, basil & salted ricotta cheese.",
        price = "10",
        image = R.drawable.pasta_tomato_sauce,
        category = Category.MAIN
    ),
    MenuItem(
        id = 5,
        title = "Bruschette",
        description = "Oven-backed bruschetta stuffed with tomato and herbs",
        price = "10",
        image = R.drawable.biscoti_tomato,
        category = Category.STARTERS
    ),
    MenuItem(
        id = 6,
        title = "Lemon Dessert",
        description = "Traditional Lemon tart, with a crispy buttery pastry crust filled with a smooth, tangy and sweet lemon flavored custard.",
        price = "15.25",
        image = R.drawable.lemon_dessert,
        category = Category.DESSERTS
    )
);
val categories = listOf(
    "Desserts",
    "Main",
    "Lunch",
    "Specials",
    "A La Carte"
)