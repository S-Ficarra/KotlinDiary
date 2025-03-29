package com.example.mydiary.domain.model

import java.util.Date


data class Story(
    val id: Int = 0,
    val text: String,
    val date : Date = Date()
)
