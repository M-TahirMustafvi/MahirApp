package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Option(val icon: Int, val title: String)

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfilePage()
                }
            }
        }
    }
}

@Composable
fun ProfilePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(26.dp))
        OptionsList()
    }
}

@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "T",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Tahir", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(
            text = "tahirmustafvi215@proton.me",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun OptionsList() {
    val optionsTop = listOf(
        Option(R.drawable.user, "Account"),
        Option(R.drawable.share, "Invite Friends / Get CashBack"),
        Option(R.drawable.shopping, "Orders"),
        Option(R.drawable.pin, "Address"),
        Option(R.drawable.icons8_coin_64, "Rewards"),
        Option(R.drawable.icons8_wallet_50, "Wallet")
    )

    val optionsBottom = listOf(
        Option(R.drawable.info, "About Us"),
        Option(R.drawable.terms_and_conditions, "Terms and Conditions"),
        Option(R.drawable.insurance, "Privacy Policy"),
        Option(R.drawable.exit, "Log Out")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
    ) {
        optionsTop.forEach { option ->
            OptionItem(icon = option.icon, title = option.title)
            Divider()
        }
    }
        Spacer(modifier = Modifier.height(36.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(4.dp, shape = RoundedCornerShape(16.dp))
        ) {
            optionsBottom.forEach { option ->
                OptionItem(icon = option.icon, title = option.title)
                Divider()
            }
        }

}

@Composable
fun Divider() {
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 15.dp), // Horizontal separator
        thickness = 1.dp,
        color = Color.LightGray
    )
}

@Composable
fun OptionItem(icon: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle click */ }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    MyApplicationTheme {
        ProfilePage()
    }
}
