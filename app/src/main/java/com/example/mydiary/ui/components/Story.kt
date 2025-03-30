package com.example.mydiary.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import com.example.mydiary.viewmodel.StoryViewModel
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun Story() {

    val viewModel: StoryViewModel = koinViewModel()
    val stories = viewModel.state.value.stories
    val currentStoryIndex = viewModel.state.value.currentStoryIndex

    fun formatDate(timestamp: Long): String {
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH)
        val date = Date(timestamp)
        return dateFormat.format(date)
    }

    if (stories.isNotEmpty()) {
        val currentStory = stories[currentStoryIndex]

        Column {
            Column(
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp)
            ) {
                Text(
                    fontWeight = FontWeight.Black,
                    text = "${formatDate(currentStory.date)} :"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    fontStyle = FontStyle.Italic,
                    text = currentStory.story
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    } else {
        Text("Aucune histoire pour le moment")
    }
}



