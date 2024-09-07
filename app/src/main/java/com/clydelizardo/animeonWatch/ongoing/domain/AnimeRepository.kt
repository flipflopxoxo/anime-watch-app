package com.clydelizardo.animeonWatch.ongoing.domain

import com.clydelizardo.models.AnimeModel

interface AnimeRepository {
    suspend fun getOngoingSeasonAnime(): Result<List<AnimeModel>>
}
