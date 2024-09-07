package com.clydelizardo.animeonWatch.details.presentation

import com.clydelizardo.models.AnimeDetailsModel

data class AnimeDetailsViewStateModel(
    val isLoading: Boolean = false,
    val animeDetails: AnimeDetailsModel? = null,
    val errorMessage: String? = null,
)
