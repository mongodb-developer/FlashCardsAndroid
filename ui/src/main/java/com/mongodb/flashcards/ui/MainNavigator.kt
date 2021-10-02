package com.mongodb.flashcards.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mongodb.flashcards.data.UseCaseFactoryProvider
import com.mongodb.flashcards.ui.viewmodels.DecksListViewModel
import com.mongodb.flashcards.ui.viewmodels.LoginViewModel

@Composable
fun MainNavigator(useCaseFactoryProvider: UseCaseFactoryProvider) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginView(navController = navController, viewModel = LoginViewModel()) }
        composable("decks") { DecksListView(viewModel = DecksListViewModel(useCaseFactoryProvider.getUseCaseFactory())) }
    }
}
