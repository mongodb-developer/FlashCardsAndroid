package com.mongodb.flashcards.data.entities

import java.util.Date

interface Deck {
    val title: String
    val deckDescription: String
    val icon: String
    val creationDate: Date
    val lastUpdateDate: Date
    val cards: List<Card>
}
