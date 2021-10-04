package com.mongodb.flashcards.data.handmade.remote.entities

data class Card(
    val id: Int,
    val title: String,
    val description: String,
    val icon: String,
    val created: String,
    val updated: String
)
