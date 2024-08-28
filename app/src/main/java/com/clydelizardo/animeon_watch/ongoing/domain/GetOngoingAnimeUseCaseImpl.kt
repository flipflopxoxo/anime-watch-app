package com.clydelizardo.animeon_watch.ongoing.domain

import com.clydelizardo.domain.AnimeModel
import com.clydelizardo.domain.PagedListModel
import javax.inject.Inject

class GetOngoingAnimeUseCaseImpl @Inject constructor(
    private val animeRepository: AnimeRepository,
): GetOngoingAnimeUseCase {
    override suspend fun invoke(page: Int): Result<PagedListModel<AnimeModel>> {
        return animeRepository.getOngoingSeasonAnime(page)
    }
}