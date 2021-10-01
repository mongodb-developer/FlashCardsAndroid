package com.mongodb.flashcards.data.entities

import java.util.Date

interface Card {
    val title: String
    val backText: String
    val icon: String
    val creationDate: Date
    val lastUpdateDate: Date
}
