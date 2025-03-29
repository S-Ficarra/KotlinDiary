package com.example.mydiary.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoryEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val story : String,
    val date: Long
)