package com.mongodb.flashcards.domain.entities

import java.util.Date

interface Card {
    val title: String
    val description: String
    val icon: String
    val creationDate: Date
    val lastUpdateDate: Date
}
