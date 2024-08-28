package com.clydelizardo.animeon_watch.ongoing.data

import com.clydelizardo.animeon_watch.ongoing.domain.AnimeRepository
import com.clydelizardo.domain.AnimeModel
import com.clydelizardo.domain.PagedListModel
import org.openapitools.network.apis.SeasonsApi
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val seasonsApi: SeasonsApi,
    private val animeToAnimeModelMapper: AnimeToAnimeModelMapper,
) : AnimeRepository {
    override suspend fun getOngoingSeasonAnime(pageNumber: Int): Result<PagedListModel<AnimeModel>> {
        try {
            val response = seasonsApi.getSeasonNow(page = pageNumber, sfw = true)
            return response.body()?.let { responseBody ->
                Result.success(
                    PagedListModel(
                        pageNumber = pageNumber,
                        hasNext = responseBody.pagination?.hasNextPage ?: false,
                        content = responseBody.data?.map {
                            animeToAnimeModelMapper.map(it)
                        }.orEmpty()
                    )
                )
            } ?: Result.failure(Exception())
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}