package com.snowyfox.littlelemonexpress.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snowyfox.littlelemonexpress.R

@Composable
fun DishMenuCard(
    title: String,
    description: String,
    price: String,
    imageResId: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 4.dp, end = 4.dp)
            .clickable { onClick() }
        ,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .weight(.7f)
                    .padding(4.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = description,
                    style = TextStyle(
                        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                        fontSize = 13.sp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer( modifier = Modifier.height(4.dp))
                Text(
                    text = "\$ $price",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                        fontSize = 18.sp,
                    ),
                    modifier = Modifier.padding(start = 10.dp, bottom = 12.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(.3f),
            ) {
                Box(
                    contentAlignment = Alignment.TopEnd
                ){
                    Image(
                        painter = painterResource(imageResId),
                        contentDescription = title,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(100.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .padding(start = 4.dp,end = 4.dp)
                    )
                }
            }
        }
    }
}
