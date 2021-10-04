package com.mongodb.flashcards.data.handmade

import com.mongodb.flashcards.data.handmade.local.LocalPersistenceDeckRepository
import com.mongodb.flashcards.data.handmade.remote.ApiDeckRepository
import com.mongodb.flashcards.domain.Repository
import com.mongodb.flashcards.domain.entities.Deck

class HandmadeDeckRepository : Repository<Deck> {
    override fun add(entity: Deck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getAll(completion: (Result<List<Deck>>) -> Unit) {
        LocalPersistenceDeckRepository().getAll { localDecksResult ->
            localDecksResult
                .onSuccess { localDecks ->
                    if (localDecks.isEmpty()) {
                        ApiDeckRepository().getAll { remoteDecksResult ->
                            remoteDecksResult
                                .onSuccess { completion(Result.success(listOf())) }
                        }
                    } else {
                        completion(Result.success(listOf()))
                    }
                }
        }
        //
        // completion(
        //     Result.success(
        //         listOf(
        //             Deck(
        //                 "Some deck",
        //                 "Deck contents",
        //                 "", Date(), Date(), listOf()
        //             )
        //         )
        //     )
        // )
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
