package com.example.mydiary.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AllStories (navController: NavController) {

    Column (
        modifier = Modifier
            .fillMaxSize(),
    ){
        Text(
        modifier = Modifier
            .padding(16.dp),
        style = MaterialTheme.typography.headlineMedium,
        text = "Mes histoires passées",
        fontSize = 32.sp,
        fontWeight = FontWeight.Black,
        color = Color.Black)

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ClickableButton("Page précédente", action = { navController.navigate("HomePage")}, 10
            )
            Spacer(modifier = Modifier.width(10.dp))
            ClickableButton("Page suivante", action = { navController.navigate("HomePage")}, 10
            )
        }
    }
}