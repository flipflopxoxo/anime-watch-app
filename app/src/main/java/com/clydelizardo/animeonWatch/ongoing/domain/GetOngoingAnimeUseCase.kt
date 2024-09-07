package com.clydelizardo.animeonWatch.ongoing.domain

import com.clydelizardo.models.AnimeModel

interface GetOngoingAnimeUseCase {
    suspend operator fun invoke(): Result<List<AnimeModel>>
}
