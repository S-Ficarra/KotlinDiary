package com.example.mydiary.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Left
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mydiary.ui.components.AllStories
import com.example.mydiary.ui.components.ClickableButton
import com.example.mydiary.ui.components.TextInput
import com.example.mydiary.ui.components.TopContainer

@Composable
fun Diary(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopContainer()
        Spacer(modifier = Modifier.height(20.dp))
        TextInput(navController)
        Spacer(modifier = Modifier.height(20.dp))
        AllStories(navController)
    }

}
