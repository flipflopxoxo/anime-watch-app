package com.clydelizardo.animeonWatch.domain.details

import com.clydelizardo.models.AnimeDetailsModel
import javax.inject.Inject

class GetAnimeDetailsUseCaseImpl
    @Inject
    constructor(
        private val repository: AnimeDetailsRepository,
    ) : GetAnimeDetailsUseCase {
        override suspend fun invoke(animeId: Int): Result<AnimeDetailsModel> = repository.getAnimeDetails(animeId)
    }
