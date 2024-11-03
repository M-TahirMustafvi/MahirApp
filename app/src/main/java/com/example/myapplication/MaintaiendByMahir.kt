package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class SubscriptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SubscriptionScreen()
                }
            }
        }
    }
}

@Composable
fun SubscriptionScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar("Maintained By Mahir")

        Spacer(modifier = Modifier.height(16.dp))

        ImageBanner()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Subscription Packages",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        SubscriptionGrid()

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar()
    }
}

@Composable
fun ImageBanner() {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = "Subscription Banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(Color.Blue)
    )
}

@Composable
fun SubscriptionGrid() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SubscriptionCard(
                title = "2 Kanals",
                oldPrice = "Rs. 10000",
                newPrice = "Rs. 6999/6 Months",
                rating = 4.9f
            )
            SubscriptionCard(
                title = "1 Kanal",
                oldPrice = "Rs. 7000",
                newPrice = "Rs. 4999/6 Months",
                rating = 4.4f
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SubscriptionCard(
                title = "7 to 10 Marlas",
                oldPrice = "Rs. 5200",
                newPrice = "Rs. 3999/6 Months",
                rating = 4.6f
            )
            SubscriptionCard(
                title = "3 to 5 Marlas",
                oldPrice = "Rs. 4000",
                newPrice = "Rs. 2999/4 Months",
                rating = 4.5f
            )
        }
    }
}

@Composable
fun SubscriptionCard(title: String, oldPrice: String, newPrice: String, rating: Float) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(120.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = "Rating",
                    tint = Color.Yellow,
                    modifier = Modifier.size(16.dp)
                )
                Text(text = rating.toString(), fontSize = 12.sp)
            }

            Column {
                Text(
                    text = oldPrice,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = newPrice,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(onClick = { /* Handle details action */ }) {
                Text(text = "Details")
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Home", Modifier.size(30.dp))
            },
            label = { Text(text = "Home") },
            selected = true,
            onClick = { /* Handle home click */ }
        )

        NavigationBarItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.shopping), contentDescription = "Orders", Modifier.size(30.dp))
            },
            label = { Text(text = "Orders") },
            selected = false,
            onClick = { /* Handle orders click */ }
        )

        NavigationBarItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.user), contentDescription = "Profile", Modifier.size(30.dp))
            },
            label = { Text(text = "Profile") },
            selected = false,
            onClick = {

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionScreenPreview() {
    MyApplicationTheme {
        SubscriptionScreen()
    }
}
