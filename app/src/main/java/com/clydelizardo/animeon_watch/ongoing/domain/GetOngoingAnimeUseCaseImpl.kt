package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel
import javax.inject.Inject

class GetOngoingAnimeUseCaseImpl @Inject constructor(
    private val animeRepository: AnimeRepository,
): GetOngoingAnimeUseCase {
    override suspend fun invoke(): Result<List<AnimeModel>> {
        return animeRepository.getOngoingSeasonAnime()
    }
}