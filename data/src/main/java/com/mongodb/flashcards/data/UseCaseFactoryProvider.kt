package com.mongodb.flashcards.data

import com.mongodb.flashcards.domain.UseCaseFactory

class UseCaseFactoryProvider(var dataSourceImplementation: DataSourceImplementation = DataSourceImplementation.HANDMADE) {
    fun getUseCaseFactory(): UseCaseFactory =
        UseCaseFactory(RepositoryFactoryProvider(dataSourceImplementation).getRepositoryFactory())
}
