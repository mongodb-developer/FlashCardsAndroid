package com.mongodb.flashcards.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FlashCardsApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
