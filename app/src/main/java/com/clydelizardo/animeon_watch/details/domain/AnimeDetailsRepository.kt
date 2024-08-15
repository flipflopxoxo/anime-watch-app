package com.clydelizardo.animeon_watch.details.domain

import com.clydelizardo.domain.AnimeDetailsModel

interface AnimeDetailsRepository {
    suspend fun getAnimeDetails(animeId: Int): Result<AnimeDetailsModel>
}