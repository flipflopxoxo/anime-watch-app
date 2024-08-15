package com.clydelizardo.animeon_watch.details.domain

import com.clydelizardo.domain.AnimeDetailsModel

interface GetAnimeDetailsUseCase {
    suspend operator fun invoke(animeId: Int): Result<AnimeDetailsModel>
}