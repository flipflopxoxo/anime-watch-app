package com.clydelizardo.animeonWatch.presentation.ongoing

import com.clydelizardo.models.AnimeModel

data class OngoingAnimeViewState(
    val isLoading: Boolean,
    val animeList: List<AnimeModel> = emptyList(),
    val errorMessage: String? = null,
)
