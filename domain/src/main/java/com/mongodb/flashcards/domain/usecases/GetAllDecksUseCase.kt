package com.mongodb.flashcards.domain.usecases

import com.mongodb.flashcards.domain.UseCase
import com.mongodb.flashcards.domain.entities.Deck

interface GetAllDecksUseCase : UseCase<Unit, List<Deck>>
