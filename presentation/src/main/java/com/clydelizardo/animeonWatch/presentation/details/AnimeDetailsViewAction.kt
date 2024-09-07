package com.clydelizardo.animeonWatch.presentation.details

import com.clydelizardo.animeonWatch.presentation.common.Action

sealed interface AnimeDetailsViewAction: Action {
    data class LoadAnimeDetails(val animeId: Int): AnimeDetailsViewAction
}