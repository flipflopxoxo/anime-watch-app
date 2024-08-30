package com.clydelizardo.animeon_watch.ongoing.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clydelizardo.animeon_watch.NavigationAction
import com.clydelizardo.animeon_watch.util.Action
import com.clydelizardo.animeon_watch.view.ErrorInlineView
import com.clydelizardo.animeon_watch.view.ErrorView
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@Preview
@Composable
private fun OngoingAnimeListViewLoading() {
    OngoingAnimeListView(
        state = OngoingAnimeViewState(isLoading = true)
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OngoingAnimeListView(
    state: OngoingAnimeViewState,
    onAction: (Action) -> Unit = { },
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(title = { Text(text = "Ongoing Anime") })
            val rememberLazyListState = rememberLazyListState()
            LaunchedEffect(rememberLazyListState) {
                snapshotFlow { rememberLazyListState.layoutInfo }
                    .map { lazyListLayoutInfo -> lazyListLayoutInfo.visibleItemsInfo.maxOf { it.index } }
                    .distinctUntilChanged()
                    .collect {
                        if (state.isReadyToLoadMore && it >= state.animeList.lastIndex) {
                            onAction(OngoingAnimeListAction.LoadMore)
                        }
                    }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                state = rememberLazyListState,
            ) {
                items(items = state.animeList, key = { it.id }) { animeModel ->
                    AnimeListItemView(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        animeModel = animeModel,
                        onClick = { onAction(NavigationAction.AnimeDetails(it.id)) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                if (state.isLoading) {
                    item(key = "loading") {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                } else if (state.errorMessage != null) {
                    item(key = "error") {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (state.animeList.isEmpty()) {
                                ErrorView(
                                    message = state.errorMessage,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(16.dp),
                                    onRetry = {
                                        onAction(OngoingAnimeListAction.Retry)
                                    }
                                )
                            } else {
                                ErrorInlineView(
                                    message = state.errorMessage,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(16.dp),
                                    onRetry = {
                                        onAction(OngoingAnimeListAction.Retry)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
