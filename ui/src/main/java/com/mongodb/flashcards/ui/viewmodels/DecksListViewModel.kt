package com.mongodb.flashcards.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mongodb.flashcards.domain.UseCaseFactory
import com.mongodb.flashcards.domain.io.DeckResult

class DecksListViewModel(useCaseFactory: UseCaseFactory) : ViewModel() {
    private var _decks = MutableLiveData<List<DeckResult>>(listOf())
    val decks: LiveData<List<DeckResult>>
        get() = _decks

    init {
        val useCase = useCaseFactory.getAllDecksUseCase()
        useCase.execute(data = Unit) { resultDecks ->
            resultDecks
                .onSuccess { _decks.value = it.map { DeckResult(title = it.title, description = it.description) } }
            // TODO: .onFailure {  }
        }
    }

    fun onAddButton() {
        TODO("Not yet implemented")
    }
}
