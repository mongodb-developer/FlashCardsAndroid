package com.mongodb.flashcards.data

import com.mongodb.flashcards.data.handmade.HandmadeRepositoryFactory
import com.mongodb.flashcards.domain.RepositoryFactory

class RepositoryFactoryProvider(var dataSourceImplementation: DataSourceImplementation) {
    fun getRepositoryFactory(): RepositoryFactory = HandmadeRepositoryFactory()
}
