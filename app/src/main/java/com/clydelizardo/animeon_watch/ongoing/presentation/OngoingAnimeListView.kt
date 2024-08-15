package com.clydelizardo.animeon_watch.ongoing.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clydelizardo.domain.AnimeModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OngoingAnimeListView(ongoingAnimeViewState: OngoingAnimeViewState) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TopAppBar(title = { Text(text = "Ongoing Anime") })
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                if (ongoingAnimeViewState.isLoading) {
                    item(key = "loading") {
                        CircularProgressIndicator()
                    }
                } else if (ongoingAnimeViewState.errorMessage != null) {
                    item(key = "error") {
                        ErrorListItem(ongoingAnimeViewState.errorMessage)
                    }
                }
                items(items = ongoingAnimeViewState.animeList, key = { it.id }) { animeModel ->
                    AnimeListItem(animeModel = animeModel)
                }
            }
        }
    }
}

@Composable
private fun ErrorListItem(errorMessage: String) {
    Text(
        text = errorMessage,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
private fun AnimeListItem(animeModel: AnimeModel) {
    Column {
        Text(text = animeModel.name)
    }
}