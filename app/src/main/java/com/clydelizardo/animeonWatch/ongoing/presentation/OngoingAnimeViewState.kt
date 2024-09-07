package com.clydelizardo.animeonWatch.ongoing.presentation

import com.clydelizardo.models.AnimeModel

data class OngoingAnimeViewState(
    val isLoading: Boolean,
    val animeList: List<AnimeModel> = emptyList(),
    val errorMessage: String? = null,
)
