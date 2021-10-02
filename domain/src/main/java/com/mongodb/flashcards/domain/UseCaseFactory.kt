package com.mongodb.flashcards.domain

import com.mongodb.flashcards.domain.usecases.GetAllDecksUseCase

class UseCaseFactory(private var repositoryFactory: RepositoryFactory) {
    fun getAllDecksUseCase(): GetAllDecksUseCase = GetAllDecksUseCase(repositoryFactory = repositoryFactory)
}
