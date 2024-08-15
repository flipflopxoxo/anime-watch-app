package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel

interface AnimeRepository {
    suspend fun getOngoingSeasonAnime(): Result<List<AnimeModel>>
}