package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel

interface GetOngoingAnimeUseCase {
    suspend operator fun invoke(): Result<List<AnimeModel>>
}