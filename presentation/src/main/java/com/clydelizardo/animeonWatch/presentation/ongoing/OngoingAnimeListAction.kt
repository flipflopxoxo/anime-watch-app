package com.clydelizardo.animeonWatch.presentation.ongoing

import com.clydelizardo.animeonWatch.presentation.common.Action

sealed interface OngoingAnimeListAction : Action {
    data class ShowAnimeDetails(
        val animeId: Int,
    ) : OngoingAnimeListAction
}
