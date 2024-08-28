package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel
import com.clydelizardo.domain.PagedListModel

interface AnimeRepository {
    suspend fun getOngoingSeasonAnime(pageNumber: Int): Result<PagedListModel<AnimeModel>>
}