package com.example.rfid_scanner_demo.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.rfid_scanner_demo.ui.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        Text(text = "This is the home screen")
        Button(onClick = { navController.navigate(Routes.SHOP) }) {
            Text("go to Shop")
        }
    }
}