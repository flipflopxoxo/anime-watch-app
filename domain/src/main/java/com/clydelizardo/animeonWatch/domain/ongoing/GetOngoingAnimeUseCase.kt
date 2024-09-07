package com.clydelizardo.animeonWatch.domain.ongoing

import com.clydelizardo.models.AnimeModel

interface GetOngoingAnimeUseCase {
    suspend operator fun invoke(): Result<List<AnimeModel>>
}
