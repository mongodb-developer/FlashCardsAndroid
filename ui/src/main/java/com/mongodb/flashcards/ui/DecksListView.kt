package com.mongodb.flashcards.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mongodb.flashcards.domain.io.DeckResult
import com.mongodb.flashcards.ui.viewmodels.DecksListViewModel

@Composable
fun DecksListView(viewModel: DecksListViewModel) {
    Scaffold(
        topBar = { AppToolbar(title = "Decks") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onAddButton()
            }) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) { contentPadding ->
        DecksList(viewModel = viewModel, modifier = Modifier.padding(contentPadding))
    }
}

@Composable
fun DecksList(viewModel: DecksListViewModel, modifier: Modifier = Modifier) {
    // <editor-fold desc="State">
    val decks by viewModel.decks.observeAsState(listOf())
    // </editor-fold>

    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(decks) { deck ->
            DecksListItem(deck = deck)
        }
    }
}

@Composable
fun DecksListItem(deck: DeckResult) {
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
            text = deck.title, modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DecksListsViewPreview() {
    FlashCardsTheme {
        DecksListView()
    }
}
*/
