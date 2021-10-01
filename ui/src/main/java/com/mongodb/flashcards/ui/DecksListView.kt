package com.mongodb.flashcards.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mongodb.flashcards.ui.theme.FlashCardsTheme
import com.mongodb.flashcards.ui.viewmodels.DecksListViewModel

@Composable
fun DecksListView(navController: NavController, viewModel: DecksListViewModel = DecksListViewModel()) {
    Column {
        AppToolbar(title = "Decks")
        DecksList(viewModel = viewModel)
    }
}

@Composable
fun DecksList(viewModel: DecksListViewModel) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(viewModel.decks) { deck ->
            DecksListItem(name = deck)
        }
    }
}

@Composable
fun DecksListItem(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(
                width = 4.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name, modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DecksListsViewPreview() {
    FlashCardsTheme {
        DecksListView(navController = NavController(LocalContext.current))
    }
}
