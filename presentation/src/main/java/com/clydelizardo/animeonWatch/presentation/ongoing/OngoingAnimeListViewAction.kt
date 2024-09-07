package com.clydelizardo.animeonWatch.presentation.ongoing

import com.clydelizardo.animeonWatch.presentation.common.Action

sealed interface OngoingAnimeListViewAction: Action {
    data object LoadOngoingAnimeList: OngoingAnimeListViewAction
}