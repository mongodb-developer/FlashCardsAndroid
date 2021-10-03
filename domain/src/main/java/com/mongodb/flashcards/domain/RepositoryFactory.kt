package com.mongodb.flashcards.domain

import com.mongodb.flashcards.domain.entities.Deck

interface RepositoryFactory {
    fun getDecksRepository(): Repository<Deck>
}
