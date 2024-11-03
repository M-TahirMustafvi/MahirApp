package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BottomNavBar(context: android.content.Context, navController: NavHostController) { // Correcting the type to android.content.Context
    NavigationBar(
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Home", Modifier.size(30.dp))
            },
            label = { Text(text = "Home") },
            selected = true,
            onClick = {
                navController.navigate("home")
            }
        )

        NavigationBarItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.shopping), contentDescription = "Orders", Modifier.size(30.dp))
            },
            label = { Text(text = "Orders") },
            selected = false,
            onClick = {

            }
        )

        NavigationBarItem(
            icon = {
                Icon(painter = painterResource(id = R.drawable.user), contentDescription = "Profile", Modifier.size(30.dp))
            },
            label = { Text(text = "Profile") },
            selected = false,
            onClick = {
                    navController.navigate("profile")
            }
        )
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = {
            Text(text = "Search", color = Color.Gray)
        },
        shape = RoundedCornerShape(8.dp)
    )
}


@Composable
fun TopBar(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center // Centering the title horizontally
    ) {
        Text(
            text = message,
            fontSize = 18.sp, // Slightly increased font size for balance
            fontWeight = FontWeight.Bold,
        )
    }
}