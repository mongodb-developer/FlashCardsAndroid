package com.mongodb.flashcards.data.handmade

import com.mongodb.flashcards.domain.Repository
import com.mongodb.flashcards.domain.entities.Deck

class HandmadeDeckRepository : Repository<Deck> {
    override fun add(entity: Deck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getAll(completion: (Result<List<Deck>>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Deck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Deck, completion: (Result<Deck>) -> Unit) {
        TODO("Not yet implemented")
    }
}
