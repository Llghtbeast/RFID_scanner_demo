package com.example.rfid_scanner_demo.ui.screens.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.rfid_scanner_demo.ui.Routes
import org.w3c.dom.Text

@Composable
fun ShopScreen(navController: NavController) {
    Column() {
        Text(text = "This is the shop screen")
        Button( onClick = { navController.navigate(Routes.HOME) }) {
            Text("go to Home")
        }
    }
}