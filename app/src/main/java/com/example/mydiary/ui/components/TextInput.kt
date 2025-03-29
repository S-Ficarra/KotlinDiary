package com.example.mydiary.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput (navController: NavController) {
    var text = remember { mutableStateOf("") }

    Column (
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            text = "Aujourd'hui",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black)
        TextField(
            value = text.value,
            onValueChange = { newText -> text.value = newText },
            textStyle = TextStyle(color = Color.Black),
            placeholder = { Text("Écrire ici les évènements de ma journée") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            maxLines = Int.MAX_VALUE,
            singleLine = false,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color(124, 232, 196),
                unfocusedIndicatorColor = Color.Gray
            )
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
            ) {
                ClickableButton("Publier", action = { navController.navigate("HomePage") }, 16
            )
        }

    }
}