package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

class ElectricianServicesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ElectricianServiceScreen(rememberNavController())
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ElectricianServiceScreen(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        bottomBar = { BottomNavBar(context, navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            TopBar("Electrician Services")
            SearchBar()
            RatingSectionElectrician()
            ServiceListElectrician()
        }
    }
}

@Composable
fun RatingSectionElectrician() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "⭐ 4.8 out of 5 stars rating",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "✔ 15234 Orders done",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ServiceListElectrician() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(electricianServices) { service ->
            ServiceItem(service)
        }
    }
}

data class Electrician_Service(
    val imageRes: Int,
    val title: String,
    val subtitle: String,
    val originalPrice: String,
    val discountedPrice: String,
    val rating: String
)

val electricianServices = listOf(
    Electrician_Service(R.drawable.electrician, "Wiring Installation", "Household wiring setup", "Rs.2000", "Rs.1500", "4.7"),
    Electrician_Service(R.drawable.electrician, "Fan Installation", "Ceiling and wall fan setup", "Rs.500", "Rs.400", "4.5"),
    // Add more items as needed
)

@Composable
fun ServiceItem(service: Electrician_Service) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = service.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = service.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = service.subtitle, fontSize = 12.sp, color = Color.Gray)
            Row {
                Text(text = service.originalPrice, color = Color.Gray, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = service.discountedPrice, fontWeight = FontWeight.Bold, color = Color.Blue)
            }
            Text(text = "⭐ ${service.rating}", fontSize = 12.sp, color = Color.Green)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { /* Add to cart action */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "ADD", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ElectricianServicePreview() {
    MyApplicationTheme {
        ElectricianServiceScreen(rememberNavController())
    }
}
