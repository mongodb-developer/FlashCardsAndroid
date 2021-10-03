package com.mongodb.flashcards.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mongodb.flashcards.data.UseCaseFactoryProvider
import com.mongodb.flashcards.ui.theme.FlashCardsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var useCaseFactoryProvider: UseCaseFactoryProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashCardsTheme {
                MainNavigator(useCaseFactoryProvider)
            }
        }
    }
}
