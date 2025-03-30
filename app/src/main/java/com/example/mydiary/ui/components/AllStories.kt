package com.example.mydiary.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.mydiary.viewmodel.StoryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllStories () {

    val viewModel: StoryViewModel = koinViewModel()
    val stories = viewModel.state.value.stories
    val currentStoryIndex = viewModel.state.value.currentStoryIndex


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            text = "Mes histoires passées",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black
        )
        if (stories.isNotEmpty()) {

        Story()

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ClickableButton(
                "Page précédente",
                action = { viewModel.previousStory() },
                10,
                enabled = currentStoryIndex > 0
            )
            Spacer(modifier = Modifier.width(10.dp))
            ClickableButton(
                "Page suivante",
                action = { viewModel.nextStory() },
                10,
                enabled = currentStoryIndex < stories.size - 1
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        }
        else {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = "Aucune histoire pour le moment")

        }
    }

}
