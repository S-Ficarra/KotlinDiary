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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mydiary.viewmodel.StoryViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput (navController: NavController) {

    val viewModel: StoryViewModel = koinViewModel()
    val text = viewModel.state.value.story


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
            value = text,
            onValueChange = { newText -> viewModel.updateStory(newText) },
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
                ClickableButton("Publier", action = { viewModel.saveStory() }, 16
            )
        }

    }
}