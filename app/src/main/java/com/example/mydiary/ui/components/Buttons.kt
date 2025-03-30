package com.example.mydiary.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClickableButton(text: String, action: () -> Unit, padding: Int, enabled : Boolean ) {
    Button(
        onClick = { action() },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(124, 232, 196),
            contentColor = Color.Black
        )
    ) {
        Text(
            modifier = Modifier
                .padding(padding.dp, 5.dp),
            text = text,
            fontSize = 16.sp,
        )
    }
}