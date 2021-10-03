package com.mongodb.flashcards.data.handmade

import com.mongodb.flashcards.domain.Repository
import com.mongodb.flashcards.domain.RepositoryFactory
import com.mongodb.flashcards.domain.entities.Deck

class HandmadeRepositoryFactory : RepositoryFactory {
    override fun getDecksRepository(): Repository<Deck> = HandmadeDeckRepository()
}
