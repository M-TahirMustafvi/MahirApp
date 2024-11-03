package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

class CleaningServicesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CleaningServicesPage(rememberNavController())
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CleaningServicesPage(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        bottomBar = { BottomNavBar(context, navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState)
                .padding(bottom = 100.dp)
        ) {
            CleaningServicesHeader()
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            CleaningServicesBanner()
            Spacer(modifier = Modifier.height(16.dp))
            AllCleaningServicesGrid()
            Spacer(modifier = Modifier.height(16.dp))
            TrendingCleaningServices()
        }
    }
}

@Composable
fun CleaningServicesHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Back", Modifier.size(30.dp))
        Text(text = "Cleaning Services", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Icon(painter = painterResource(id = R.drawable.phone), contentDescription = "Call", Modifier.size(30.dp))
    }
}

@Composable
fun CleaningServicesBanner() {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = "Cleaning Banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 16.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    )
}

@Composable
fun AllCleaningServicesGrid() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "All Services", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        val services = listOf(
            Pair("Solar Panel Cleaning", R.drawable.solar),
            Pair("Sofa Cleaning", R.drawable.sofa),
            Pair("Water Tank Cleaning", R.drawable.water_tank_plastic),
            Pair("Mattress Cleaning", R.drawable.mattress),
            Pair("Deep Cleaning", R.drawable.commercial_deep_cleaning),
            Pair("Curtain Cleaning", R.drawable.curtain),
            Pair("Chair Cleaning", R.drawable.chair),
            Pair("Cement Water Tank Cleaning", R.drawable.water_tank_cement),
            Pair("Carpet Cleaning", R.drawable.carpet),
            Pair("Car Wash", R.drawable.car_service),
            Pair("Car Detailing", R.drawable.detailing)
        )

        Column {
            services.chunked(3).forEach { rowServices ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowServices.forEach { (name, icon) ->
                        ServiceItem(name = name, icon = icon, rememberNavController())
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TrendingCleaningServices() {
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
            TrendingServiceCard("Sofa Cleaning", R.drawable.sofa, "Rs. 1750", rememberNavController())
            TrendingServiceCard("Car Detailing", R.drawable.detailing, "Rs. 4250", rememberNavController())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CleaningServicesPagePreview() {
    MyApplicationTheme {
        CleaningServicesPage(rememberNavController())
    }
}
