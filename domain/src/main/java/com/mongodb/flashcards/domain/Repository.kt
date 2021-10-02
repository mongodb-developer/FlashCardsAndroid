package com.mongodb.flashcards.domain

interface Repository<ENTITY> {
    // / Adds one Entity
    // / - parameter ``completion``: closure that returns the added Entity
    fun add(entity: ENTITY, completion: (Result<Unit>) -> Unit)

    // / Gets all Entities of this type
    // / - parameter ``completion``: closure to return all Entities
    fun getAll(completion: (Result<List<ENTITY>>) -> Unit)

    // / Deletes one entity
    // / - parameter ``completion``: closure to return success or failure
    fun delete(entity: ENTITY, completion: (Result<Unit>) -> Unit)

    // / Deletes all entities
    // / - parameter ``completion``: closure to return success or failure
    fun deleteAll(completion: (Result<Unit>) -> Unit)

    // / Updates one Entity
    // / - parameter ``completion``: closure that returns the updated Entity
    fun update(entity: ENTITY, completion: (Result<ENTITY>) -> Unit)
}
