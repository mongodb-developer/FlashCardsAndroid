package com.mongodb.flashcards.data.handmade.remote.entities

import java.util.Date
import com.mongodb.flashcards.domain.entities.Deck as DomainDeck

data class Deck(
    val id: Int,
    val title: String,
    val description: String,
    val icon: String,
    val created: String,
    val updated: String,
    val cards: List<Card>
) {
    fun toDomain(): DomainDeck =
        DomainDeck(title, description, toString(), Date(), Date(), listOf())
}
