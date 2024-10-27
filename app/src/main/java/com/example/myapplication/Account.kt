package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class AccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AccountPage()
                }
            }
        }
    }
}

@Composable
fun AccountPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        AccountHeader()
        Spacer(modifier = Modifier.height(16.dp))
        AccountEditSection()
        Spacer(modifier = Modifier.height(16.dp))
        DeleteAccountSection()
    }
}

@Composable
fun AccountHeader() {
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
        Text(
            text = "Account",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(40.dp)) // For balance
    }
}

@Composable
fun AccountEditSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Profile picture
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "T", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tahir",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Text(
            text = "tahirmustafvi215@proton.me",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = "ic_edit",
            modifier = Modifier
                .size(24.dp)
                .clickable { /* Add action to ic_edit profile */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Account details
        AccountDetailRow(label = "Name", value = "Tahir", editable = true)
        AccountDetailRow(label = "Gender", value = "male", editable = true)
        AccountDetailRow(label = "Phone Number", value = "+92 349 4789703", editable = true)
        AccountDetailRow(label = "Email Address", value = "tahirmustafvi215@proton.me", editable = true)
    }
}

@Composable
fun AccountDetailRow(label: String, value: String, editable: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(text = value, fontSize = 14.sp)
        }

        if (editable) {
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "ic_edit $label",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Add action to ic_edit field */ }
            )
        }
    }
}

@Composable
fun DeleteAccountSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Add action to delete account */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Delete Account",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Red,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.exit),
            contentDescription = "Delete Account",
            modifier = Modifier.size(24.dp),
            tint = Color.Red
        )
    }

    Text(
        text = "Delete Account and associated Data",
        fontSize = 12.sp,
        color = Color.Gray,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AccountPagePreview() {
    MyApplicationTheme {
        AccountPage()
    }
}
