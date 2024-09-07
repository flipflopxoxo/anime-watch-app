package com.clydelizardo.animeonWatch.details.domain

import com.clydelizardo.models.AnimeDetailsModel

interface GetAnimeDetailsUseCase {
    suspend operator fun invoke(animeId: Int): Result<AnimeDetailsModel>
}
