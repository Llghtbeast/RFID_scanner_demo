package com.example.rfid_scanner_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rfid_scanner_demo.ui.Navigation
import com.example.rfid_scanner_demo.ui.screens.home.HomeScreen
import com.example.rfid_scanner_demo.ui.theme.RFID_scanner_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RFID_scanner_demoTheme {
                Surface {
                    Navigation()
                }
            }
        }
    }
}