package com.mongodb.flashcards.data.handmade.remote

import com.google.gson.GsonBuilder
import com.mongodb.flashcards.data.handmade.remote.entities.DeckApiResponse
import com.mongodb.flashcards.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import com.mongodb.flashcards.domain.entities.Deck as DomainDeck

class ApiDeckRepository : Repository<DomainDeck> {

    val baseURL = URL("https://realmflashcards.netlify.app/api/")

    override fun add(entity: DomainDeck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getAll(completion: (Result<List<DomainDeck>>) -> Unit) {
        val endPoint = "decks.json"
        val url = URL(
            baseURL.getProtocol(),
            baseURL.getHost(),
            baseURL.getPort(),
            baseURL.getPath().toString() + endPoint,
            null
        )
        CoroutineScope(Dispatchers.IO).launch {
            println("URL: $url")
            val urlConnection = url.openConnection() as HttpsURLConnection
            try {
                println("REST API (result ${urlConnection.responseCode})")
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    val jsonResponse = urlConnection.inputStream
                        .bufferedReader()
                        .use { it.readText() } // defaults to UTF-8
                    val response: DeckApiResponse = GsonBuilder().create().fromJson(jsonResponse, DeckApiResponse::class.java)
                    println("Decks: $response")
                    val domainDecks = response.decks.map { it.toDomain() }
                    MainScope().launch {
                        completion(Result.success(domainDecks))
                    }
                } else {
                    println("Connection error: {urlConnection.responseCode.toString()}")
                }
            } finally {
                urlConnection.disconnect()
            }
        }
    }

    override fun delete(entity: DomainDeck, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun update(entity: DomainDeck, completion: (Result<DomainDeck>) -> Unit) {
        TODO("Not yet implemented")
    }
}
