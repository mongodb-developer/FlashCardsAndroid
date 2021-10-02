package com.mongodb.flashcards.ui.viewmodels

import androidx.lifecycle.ViewModel
// import com.mongodb.flashcards.domain.UseCaseFactory
import com.mongodb.flashcards.domain.io.DeckResult

class DecksListViewModel(/*private var useCaseFactory: UseCaseFactory*/) : ViewModel() {
    var decks: List<DeckResult> = listOf()

/*    fun onLoad() {
        val useCase =  useCaseFactory.getAllDecksUseCase()
        useCase.execute(data = Unit) { resultDecks ->
            resultDecks
                .onSuccess { decks = it.map { DeckResult(title = it.title, description = it.description)} }
                // TODO: .onFailure {  }
        }
    }*/

    fun onAddButton() {
        TODO("Not yet implemented")
    }
}
