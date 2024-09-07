package com.clydelizardo.animeonWatch.domain.details

import com.clydelizardo.models.AnimeDetailsModel

interface AnimeDetailsRepository {
    suspend fun getAnimeDetails(animeId: Int): Result<AnimeDetailsModel>
}
