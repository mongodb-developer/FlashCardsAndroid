package com.mongodb.flashcards.ui.di

import com.mongodb.flashcards.data.UseCaseFactoryProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class UseCaseFactoryProviderModule {
    @Provides
    fun provideUseCaseFactoryProvider() = UseCaseFactoryProvider()
}
