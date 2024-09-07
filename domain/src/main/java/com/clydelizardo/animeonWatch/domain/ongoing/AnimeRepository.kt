package com.clydelizardo.animeonWatch.domain.ongoing

import com.clydelizardo.models.AnimeModel

interface AnimeRepository {
    suspend fun getOngoingSeasonAnime(): Result<List<AnimeModel>>
}
