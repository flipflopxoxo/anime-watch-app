package com.clydelizardo.animeonWatch.ongoing.domain

import com.clydelizardo.models.AnimeModel
import javax.inject.Inject

class GetOngoingAnimeUseCaseImpl
    @Inject
    constructor(
        private val animeRepository: AnimeRepository,
    ) : GetOngoingAnimeUseCase {
        override suspend fun invoke(): Result<List<AnimeModel>> = animeRepository.getOngoingSeasonAnime()
    }
