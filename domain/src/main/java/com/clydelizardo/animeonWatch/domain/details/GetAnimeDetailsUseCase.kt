package com.clydelizardo.animeonWatch.domain.details

import com.clydelizardo.models.AnimeDetailsModel

interface GetAnimeDetailsUseCase {
    suspend operator fun invoke(animeId: Int): Result<AnimeDetailsModel>
}
