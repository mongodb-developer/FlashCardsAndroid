package com.mongodb.flashcards.data

import com.mongodb.flashcards.domain.UseCaseFactory

class UseCaseFactoryProvider(var dataSourceImplementation: DataSourceImplementation = DataSourceImplementation.HANDMADE) {
    fun getUseCaseBuilder(): UseCaseFactory =
        UseCaseFactory(RepositoryFactoryProvider(dataSourceImplementation).getRepositoryFactory())
}
