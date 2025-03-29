package com.example.mydiary.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import com.example.mydiary.ui.components.ClickableButton
import com.example.mydiary.ui.components.TopContainer


@Composable
fun HomePage (navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopContainer()
        Spacer(modifier = Modifier.weight(2f))
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = "Mon journal",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black)
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = "intime",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        ClickableButton("Ouvrir >", action = { navController.navigate("Diary") }, 16 )
        Spacer(modifier = Modifier.weight(.5f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .background(
                    Color(124, 232, 196),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
        )

    }
}