package com.example.mydiary.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mydiary.ui.components.*

@Composable
fun Diary() {


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopContainer()
        Spacer(modifier = Modifier.height(20.dp))
        TextInput()
        Spacer(modifier = Modifier.height(20.dp))
        AllStories()
    }

}
