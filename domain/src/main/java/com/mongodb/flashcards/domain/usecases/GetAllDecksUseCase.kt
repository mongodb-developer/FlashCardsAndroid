package com.mongodb.flashcards.domain.usecases

import com.mongodb.flashcards.domain.BusinessRule
import com.mongodb.flashcards.domain.RepositoryFactory
import com.mongodb.flashcards.domain.UseCase
import com.mongodb.flashcards.domain.entities.Deck

class GetAllDecksUseCase(private val repositoryFactory: RepositoryFactory, override var businessRules: List<BusinessRule>? = null) : UseCase<Unit, List<Deck>> {

    override fun execute(data: Unit, completion: (Result<List<Deck>>) -> Unit) {
        val decksRepository = repositoryFactory.getDecksRepository()
        decksRepository.getAll() { repoResult ->
            repoResult
                .onSuccess { deckList ->
                    completion(Result.success(deckList))
                }
                .onFailure {
                    completion(Result.failure(it))
                }
        }
    }
}
