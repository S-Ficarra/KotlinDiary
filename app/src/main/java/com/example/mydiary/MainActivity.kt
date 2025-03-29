package com.example.mydiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.mydiary.ui.navigation.Navigation
import com.example.mydiary.ui.theme.MyDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDiaryTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigation() // Appelle la navigation
                }
            }
        }
    }
}
