package com.example.mydiary.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoryDAO {
    @Insert
    suspend fun insertStory(story: StoryEntity): Long

    @Query("SELECT * FROM storyEntity")
    suspend fun allStories() : List<StoryEntity>

}