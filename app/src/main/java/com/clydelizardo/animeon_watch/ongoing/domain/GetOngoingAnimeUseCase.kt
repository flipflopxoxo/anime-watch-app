package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel

interface GetOngoingAnimeUseCase {
    operator fun invoke(): List<AnimeModel>
}