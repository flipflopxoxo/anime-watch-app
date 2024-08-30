package com.clydelizardo.animeon_watch.ongoing.presentation

import com.clydelizardo.domain.AnimeModel

data class OngoingAnimeViewState(
    val isLoading: Boolean,
    val animeList: List<AnimeModel> = emptyList(),
    val pagesLoaded: Int = 0,
    val hasNext: Boolean = true,
    val errorMessage: String? = null,
)

val OngoingAnimeViewState.isReadyForRetry: Boolean
    get() = errorMessage != null && !isLoading && hasNext

val OngoingAnimeViewState.isReadyToLoadMore: Boolean
    get() = !isLoading && hasNext && errorMessage == null