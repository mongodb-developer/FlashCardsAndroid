package com.mongodb.flashcards.data.handmade.local

import com.mongodb.flashcards.domain.Repository
import com.mongodb.flashcards.domain.entities.Deck

// This repo stores data locally as a cache
class LocalPersistenceDeckRepository : Repository<Deck> {
    override fun add(entity: Deck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getAll(completion: (Result<List<Deck>>) -> Unit) {
        // At the moment it does nothing.
        completion(Result.success(listOf()))
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
