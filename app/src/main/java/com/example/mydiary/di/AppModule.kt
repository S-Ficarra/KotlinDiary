package com.example.mydiary.di

import androidx.room.Room
import com.example.mydiary.data.AppDatabase
import com.example.mydiary.viewmodel.StoryViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "ma_base.db"
        ).build()
    }

    viewModel {
        StoryViewModel(get())
    }

}