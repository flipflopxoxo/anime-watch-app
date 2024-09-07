package com.clydelizardo.animeonWatch.presentation.details

import com.clydelizardo.models.AnimeDetailsModel

data class AnimeDetailsViewStateModel(
    val isLoading: Boolean = false,
    val animeDetails: AnimeDetailsModel? = null,
    val errorMessage: String? = null,
)
