package com.clydelizardo.animeon_watch.details.domain

import com.clydelizardo.animeon_watch.ongoing.domain.AnimeRepository
import com.clydelizardo.domain.AnimeDetailsModel
import javax.inject.Inject

class GetAnimeDetailsUseCaseImpl @Inject constructor(
    private val repository: AnimeDetailsRepository
) : GetAnimeDetailsUseCase {
    override suspend fun invoke(animeId: Int): Result<AnimeDetailsModel> {
        return repository.getAnimeDetails(animeId)
    }
}