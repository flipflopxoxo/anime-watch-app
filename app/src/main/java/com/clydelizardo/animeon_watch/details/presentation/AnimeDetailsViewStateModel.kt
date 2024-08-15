package com.clydelizardo.animeon_watch.details.presentation

import com.clydelizardo.domain.AnimeDetailsModel

data class AnimeDetailsViewStateModel(
    val isLoading: Boolean = false,
    val animeDetails: AnimeDetailsModel? = null,
    val errorMessage: String? = null,
)