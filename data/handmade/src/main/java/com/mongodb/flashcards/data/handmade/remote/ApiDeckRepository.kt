package com.mongodb.flashcards.data.handmade.remote

import com.mongodb.flashcards.domain.Repository
import com.mongodb.flashcards.domain.entities.Deck
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class ApiDeckRepository : Repository<Deck> {

    val baseURL = URL("https://realmflashcards.netlify.app/api/")

    override fun add(entity: Deck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getAll(completion: (Result<List<Deck>>) -> Unit) {
        val endPoint = "/decks.json"
        val url = URL(
            baseURL.getProtocol(),
            baseURL.getHost(),
            baseURL.getPort(),
            baseURL.getPath().toString() + endPoint,
            null
        )
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val data = BufferedInputStream(urlConnection.getInputStream())
            println("REST API result: $data")
        } finally {
            urlConnection.disconnect()
        }
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
