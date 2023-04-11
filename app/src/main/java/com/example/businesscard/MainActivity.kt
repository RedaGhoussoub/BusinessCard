package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(0.7f)) {
            BusinessCardHeader(
                name = "Reda Ghoussoub",
                title = "Kickass Android Developer",
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(0.3f)) {
            BusinessCardContact(
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun BusinessCardHeader(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.ic_android_green_24dp)
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
    }
}

@Composable
fun BusinessCardContact(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        BusinessCardContactText(
            iconResource = R.drawable.baseline_phone_24,
            text = "+11 (123) 444 555 666"
        )
        BusinessCardContactText(
            iconResource = R.drawable.baseline_share_24,
            text = "@AndroidDev"
        )
        BusinessCardContactText(
            iconResource = R.drawable.baseline_email_24,
            text = "awesome@androiddev.com"
        )
    }
}

@Composable
fun BusinessCardContactText(iconResource: Int, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        val image = painterResource(id = iconResource)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.weight(0.2f)
        )
        Text(
            text = text,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(0.8f),
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}