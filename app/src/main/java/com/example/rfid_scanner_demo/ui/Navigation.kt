package com.example.rfid_scanner_demo.ui

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rfid_scanner_demo.ui.screens.home.HomeScreen
import com.example.rfid_scanner_demo.ui.screens.shop.ShopScreen

object Routes {
    const val HOME = "home"
    const val SHOP = "shop"
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        composable(Routes.HOME) {
            HomeScreen(navController = navController)
        }

        composable(Routes.SHOP) {
            ShopScreen(navController = navController)
        }
    }
}