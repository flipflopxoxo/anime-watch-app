package com.clydelizardo.animeon_watch.ongoing.presentation

import com.clydelizardo.animeon_watch.util.Action

sealed interface OngoingAnimeListAction: Action {
    data object LoadMore: OngoingAnimeListAction
    data object Retry: OngoingAnimeListAction
}