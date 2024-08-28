package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel
import com.clydelizardo.domain.PagedListModel

interface GetOngoingAnimeUseCase {
    suspend operator fun invoke(page: Int = 1): Result<PagedListModel<AnimeModel>>
}