package com.mongodb.flashcards.ui.viewmodels

import androidx.lifecycle.ViewModel

class DecksListViewModel : ViewModel() {
    var decks: List<String> = listOf("Architecture", "Testing")

    fun onAddButton() {
        TODO("Not yet implemented")
    }
}
