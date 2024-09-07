package com.clydelizardo.animeonWatch.details.domain

import com.clydelizardo.models.AnimeDetailsModel

interface AnimeDetailsRepository {
    suspend fun getAnimeDetails(animeId: Int): Result<AnimeDetailsModel>
}
