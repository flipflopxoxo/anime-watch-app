package com.clydelizardo.animeonWatch.data.ongoing

import com.clydelizardo.animeonWatch.data.common.convertResponseToResult
import com.clydelizardo.animeonWatch.domain.ongoing.AnimeRepository
import com.clydelizardo.models.AnimeModel
import org.openapitools.network.apis.SeasonsApi
import javax.inject.Inject

class AnimeRepositoryImpl
@Inject
constructor(
    private val seasonsApi: SeasonsApi,
    private val animeToAnimeModelMapper: AnimeToAnimeModelMapper,
) : AnimeRepository {
    override suspend fun getOngoingSeasonAnime(): Result<List<AnimeModel>> {
        return convertResponseToResult(
            requestCall = {
                seasonsApi.getSeasonNow()
            },
            mapOutput = { animeSearch ->
                animeSearch?.data
                    ?.map {
                        animeToAnimeModelMapper.map(it)
                    }.orEmpty()
            }
        )
    }
}
