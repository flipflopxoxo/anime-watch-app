package com.clydelizardo.animeon_watch.ongoing.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clydelizardo.animeon_watch.NavigationAction
import com.clydelizardo.animeon_watch.view.ErrorView

@Preview
@Composable
private fun OngoingAnimeListViewLoading() {
    OngoingAnimeListView(
        ongoingAnimeViewState = OngoingAnimeViewState(isLoading = true),
        onNavigate = {},
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OngoingAnimeListView(
    ongoingAnimeViewState: OngoingAnimeViewState,
    onNavigate: (NavigationAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(title = { Text(text = "Ongoing Anime") })
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                if (ongoingAnimeViewState.isLoading) {
                    item(key = "loading") {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                } else if (ongoingAnimeViewState.errorMessage != null) {
                    item(key = "error") {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ErrorView(
                                message = ongoingAnimeViewState.errorMessage,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
                items(items = ongoingAnimeViewState.animeList, key = { it.id }) { animeModel ->
                    AnimeListItemView(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        animeModel = animeModel,
                        onClick = { onNavigate(NavigationAction.AnimeDetails(it.id)) }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}
