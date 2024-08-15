package com.clydelizardo.animeon_watch.ongoing.presentation

import com.clydelizardo.domain.AnimeModel

data class OngoingAnimeViewState(
    val isLoading: Boolean,
    val animeList: List<AnimeModel> = emptyList(),
    val errorMessage: String? = null,
)