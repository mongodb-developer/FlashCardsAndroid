package com.mongodb.flashcards.domain.usecases.deck

import com.mongodb.flashcards.domain.entities.Deck
import com.mongodb.flashcards.domain.usecases.UseCase

interface GetAllDecksUseCase : UseCase<Unit, List<Deck>>
