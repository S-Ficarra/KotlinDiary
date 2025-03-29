package com.example.mydiary.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StoryEntity::class], version = 1 )
abstract class AppDatabase : RoomDatabase () {
    abstract fun storyDAO() : StoryDAO
}