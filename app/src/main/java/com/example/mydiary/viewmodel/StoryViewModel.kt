package com.example.mydiary.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydiary.data.AppDatabase
import com.example.mydiary.data.StoryEntity
import kotlinx.coroutines.launch

class StoryViewModel(private val db : AppDatabase) : ViewModel() {

    val state = mutableStateOf(StoryState(story = ""))

    fun updateStory(newStory: String) {
        state.value = state.value.copy(story = newStory)
    }

    fun saveStory() {
        val textToSave = state.value.story
        if (textToSave.isNotBlank()) {
            Log.d("StoryViewModel", "Tentative d'enregistrement de l'histoire: $textToSave")
            viewModelScope.launch {
                try {
                    val id = db.storyDAO().insertStory(
                        StoryEntity(
                            id = 0,
                            story = textToSave,
                            date = System.currentTimeMillis()
                        )
                    )
                    Log.d("StoryViewModel", "Histoire enregistrée avec succès avec l'ID: $id")
                } catch (e: Exception) {
                    Log.e("StoryViewModel", "Erreur lors de l'enregistrement de l'histoire", e)
                }
            }
        } else {
            Log.w("StoryViewModel", "Tentative d'enregistrement d'une histoire vide - ignorée")
        }
    }
}