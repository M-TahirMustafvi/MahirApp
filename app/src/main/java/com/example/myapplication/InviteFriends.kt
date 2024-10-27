package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class ReferralActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReferralScreen()
                }
            }
        }
    }
}

@Composable
fun ReferralScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        ReferralHeader()
        Spacer(modifier = Modifier.height(16.dp))
        ReferralContent()
        Spacer(modifier = Modifier.height(16.dp))
        ShareButton()
    }
}

@Composable
fun ReferralHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Back",
            Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

    }
}

@Composable
fun ReferralContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Gift Image
        Image(
            painter = painterResource(id = R.drawable.bonus),
            contentDescription = "Gift",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Invite friends, get Rs. 100.00",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
           // modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Instructions
        Text(
            text = "1. Your friends will get Rs.150",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Ask them to just sign up and place & complete orders using your referral code.",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "2. You will get Rs.100",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Upon every order completion with your referral code.",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Terms and Condition",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Referral code will be applicable above 1000 amount.",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Referral Code
        Text(
            text = "Your Referral Code",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "450ee85d",
                    fontSize = 16.sp
                )
                Icon(
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = "Copy",
                    modifier = Modifier.size(24.dp).clickable {
                        // Handle copy action
                    }
                )
            }
        }
    }
}

@Composable
fun ShareButton() {
    Button(
        onClick = { /* Handle share action */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Share with Loved Ones", fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ReferralScreenPreview() {
    MyApplicationTheme {
        ReferralScreen()
    }
}
