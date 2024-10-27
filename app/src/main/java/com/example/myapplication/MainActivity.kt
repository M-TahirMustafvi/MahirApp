package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { MahirHomePage(navController) }
                    composable("profile") { ProfilePage(navController) }
                    composable("homeServices") { HomeServicesPage(navController) }
                    composable("salonServices") {  }
                    composable("cleaningServices") { CleaningServicesPage(navController) }
                    composable("mahirMaintained") { SubscriptionScreen() }
                    composable("account") { AccountPage() }
                    composable("referral") { ReferralScreen() }

                }
            }
        }
    }
}

@Composable
fun MahirHomePage(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(onMenuClick = { navController.navigate("profile") })
        WelcomeSection()
        CoinsAndWalletRow()
        ServiceGrid(navController) // Pass navController here
    }
}

@Composable
fun TopBar(onMenuClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Menu Icon
        Icon(
            painter = painterResource(id = R.drawable.icons8_menu_50),
            contentDescription = "Menu",
            modifier = Modifier
                .size(24.dp)
                .clickable { onMenuClick() } // Navigate to Account on menu click
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = "Home",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = stringResource(R.string.Address),
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun WelcomeSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Welcome to Mahir Company",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Hello, Tahir", fontSize = 16.sp)
    }
}

@Composable
fun CoinsAndWalletRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Coins Button
        CoinWalletButton(
            label = "0 Coins",
            icon = R.drawable.icons8_coin_64
        )

        // Wallet Button
        CoinWalletButton(
            label = "0 Wallet",
            icon = R.drawable.icons8_wallet_50
        )
    }
}

@Composable
fun CoinWalletButton(label: String, icon: Int) {
    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        modifier = Modifier
            .width(160.dp)
            .height(50.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, color = Color.White)
    }
}

@Composable
fun ServiceGrid(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        ServiceRow(
            leftService = Service("Home Services", R.drawable.handyman1, "Residential", "Commercial"),
            rightService = Service("Salon Services", R.drawable.beautician1, "Females Only"),
            navController = navController // Pass navController here
        )

        Spacer(modifier = Modifier.height(16.dp))

        FullWidthServiceCard(
            service = Service("Cleaning Services", R.drawable.cleaning1, "Residential", "Commercial"),
            navController = navController // Pass navController here
        )

        Spacer(modifier = Modifier.height(16.dp))

        FullWidthServiceCard(
            service = Service("Maintained by Mahir", R.drawable.cleaning1, "Residential", "Commercial"),
            navController = navController // Pass navController here
        )
    }
}

@Composable
fun ServiceRow(leftService: Service, rightService: Service, navController: NavHostController) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        ServiceCard(service = leftService, navController = navController)
        Spacer(modifier = Modifier.width(16.dp))
        ServiceCard(service = rightService, navController = navController)
    }
}

@Composable
fun ServiceCard(service: Service, navController: NavHostController, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .clickable {
                // Navigate based on the service name
                when (service.name) {
                    "Home Services" -> navController.navigate("homeServices")
                    "Salon Services" -> navController.navigate("salonServices")
                    "Cleaning Services" -> navController.navigate("cleaningServices")
                    "Maintained by Mahir" -> navController.navigate("mahirMaintained")
                }
            }
            .width(160.dp)
            .height(170.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = service.imageRes),
                contentDescription = service.name,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = service.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            if (service.tagline.isNotEmpty()) {
                Text(text = service.tagline, fontSize = 12.sp, color = Color.Red)
            }
        }
    }
}

@Composable
fun FullWidthServiceCard(service: Service, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                // Navigate based on the service name
                when (service.name) {
                    "Cleaning Services" -> navController.navigate("cleaningServices")
                    "Maintained by Mahir" -> navController.navigate("mahirMaintained")
                }
            },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = service.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                if (service.tagline.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = service.tagline,
                        fontSize = 12.sp,
                        color = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = service.imageRes),
                contentDescription = service.name,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

// Sample Data
data class Service(val name: String, val imageRes: Int, val tagline: String = "", val secondTag: String = "")

@Preview(showBackground = true)
@Composable
fun MahirHomePagePreview() {
    MyApplicationTheme {
        MahirHomePage(rememberNavController()) // For preview, you can pass a dummy NavController
    }
}