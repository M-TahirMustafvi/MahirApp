package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class HomeServicesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeServicesPage(rememberNavController())
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeServicesPage(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current // Correct usage of context in Compose

    Scaffold(
        bottomBar = { BottomNavBar(context, navController) } // Passing the correct context to BottomNavBar
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState)
                .padding(bottom = 100.dp)
        ) {
            HomeServicesHeader()
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            HomeServicesBanner()
            Spacer(modifier = Modifier.height(16.dp))
            TrendingServices(navController) // Pass navController here
            Spacer(modifier = Modifier.height(16.dp))
            AllServicesGrid(navController) // Pass navController here
            Spacer(modifier = Modifier.height(24.dp))
            ExploreCleaningServices()
        }
    }
}

@Composable
fun HomeServicesHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Back", Modifier.size(30.dp))
        Text(text = "Home Services", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Icon(painter = painterResource(id = R.drawable.phone), contentDescription = "Call", Modifier.size(30.dp))
    }
}

@Composable
fun HomeServicesBanner() {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = "Banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 16.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    )
}

@Composable
fun TrendingServices(navController: NavHostController) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Trending Services", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "View All", color = Color.Blue)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            TrendingServiceCard("AC Installation", R.drawable.ac, "Rs. 2800", navController)
            TrendingServiceCard("Furniture Polish", R.drawable.handyman, "Rs. 1500", navController)
        }
    }
}

@Composable
fun TrendingServiceCard(serviceName: String, iconRes: Int, price: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .size(150.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable { navController.navigate("serviceName") } // Add navigation here
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = serviceName,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = serviceName, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = price, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun AllServicesGrid(navController: NavHostController) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "All Services", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        val services = listOf(
            Pair("AC Services", R.drawable.ac),
            Pair("Carpenter", R.drawable.handyman),
            Pair("Electrician", R.drawable.electrician),
            Pair("Geyser", R.drawable.geyser),
            Pair("Handyman", R.drawable.handyman),
            Pair("Home Appliances", R.drawable.home_inspection),
            Pair("Painter", R.drawable.painter),
            Pair("Pest Control", R.drawable.pest_control),
            Pair("Plumber", R.drawable.plumber)
        )

        Column {
            services.chunked(3).forEach { rowServices ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowServices.forEach { (name, icon) ->
                        ServiceItem(name = name, icon = icon, navController = navController) // Pass navController here
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ServiceItem(name: String, icon: Int, navController: NavHostController) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clickable { navController.navigate(name) }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = name,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name, fontSize = 14.sp)
    }
}

@Composable
fun ExploreCleaningServices() {
    Button(
        onClick = { /* Navigate to Cleaning Services */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = "Explore Cleaning Services")
    }
}

@Preview(showBackground = true)
@Composable
fun HomeServicesPagePreview() {
    MyApplicationTheme {
        HomeServicesPage(rememberNavController())
    }
}
