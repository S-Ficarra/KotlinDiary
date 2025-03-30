package com.example.mydiary.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydiary.data.AppDatabase
import com.example.mydiary.data.StoryEntity
import kotlinx.coroutines.launch


class StoryViewModel(private val db : AppDatabase) : ViewModel() {

    val state = mutableStateOf(StoryState(story = ""))

    init {
        loadAllStories()
    }

    private fun loadAllStories() {
        viewModelScope.launch {
            try {
                val allStories = db.storyDAO().allStories()
                state.value = state.value.copy(
                    stories = allStories.sortedByDescending { it.date },
                    currentStoryIndex = 0
                )
            } catch (e: Exception) {
                Log.e("StoryViewModel", "Erreur lors de la récupération des histoires", e)
            }
        }
    }

    fun nextStory() {
        val nextIndex = (state.value.currentStoryIndex + 1).coerceAtMost(state.value.stories.size - 1)
        state.value = state.value.copy(currentStoryIndex = nextIndex)
    }

    fun previousStory() {
        val previousIndex = (state.value.currentStoryIndex - 1).coerceAtLeast(0)
        state.value = state.value.copy(currentStoryIndex = previousIndex)
    }

    fun updateStory(newStory: String) {
        state.value = state.value.copy(story = newStory)
    }

    fun saveStory() {
        val textToSave = state.value.story
        if (textToSave.isNotBlank()) {
            viewModelScope.launch {
                try {
                    db.storyDAO().insertStory(
                        StoryEntity(
                            id = 0,
                            story = textToSave,
                            date = System.currentTimeMillis()
                        )
                    )
                    state.value = state.value.copy(story = "")
                } catch (e: Exception) {
                    Log.e("StoryViewModel", "Erreur lors de l'enregistrement de l'histoire", e)
                }
            }
        }
    }

}