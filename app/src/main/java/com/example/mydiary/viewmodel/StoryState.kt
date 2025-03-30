package com.example.mydiary.viewmodel

import com.example.mydiary.data.StoryEntity

data class StoryState (

    val story : String,
    val stories: List<StoryEntity> = emptyList(),
    val currentStoryIndex: Int = 0

)