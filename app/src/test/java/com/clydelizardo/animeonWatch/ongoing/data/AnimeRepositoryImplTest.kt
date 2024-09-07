package com.clydelizardo.animeonWatch.ongoing.data

import com.clydelizardo.animeonWatch.MainCoroutineRule
import com.clydelizardo.models.AnimeModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.openapitools.network.apis.SeasonsApi
import org.openapitools.network.models.Anime
import org.openapitools.network.models.AnimeSearch
import retrofit2.Response

class AnimeRepositoryImplTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var repositoryImpl: AnimeRepositoryImpl

    @MockK
    lateinit var seasonsApi: SeasonsApi

    @MockK
    lateinit var mapper: AnimeToAnimeModelMapper

    @Test
    fun `Given API is available, When requesting details, Then mapped result is returned`() =
        runTest {
            val mockAnime = mockk<Anime>()
            val successResponseBody =
                mockk<AnimeSearch> {
                    every { data } returns listOf(mockAnime)
                }
            val mockAnimeModel = mockk<AnimeModel>()
            coEvery { seasonsApi.getSeasonNow() } returns Response.success(successResponseBody)
            coEvery { mapper.map(mockAnime) } returns mockAnimeModel

            repositoryImpl = AnimeRepositoryImpl(seasonsApi, mapper)
            val result = repositoryImpl.getOngoingSeasonAnime()
            assertEquals(Result.success(listOf(mockAnimeModel)), result)
        }

    @Test
    fun `Given API is unavailable, When requesting details, Then failure result is returned`() =
        runTest {
            val failureResponse =
                mockk<Response<AnimeSearch>> {
                    every { isSuccessful } returns false
                }
            coEvery { seasonsApi.getSeasonNow() } returns failureResponse

            repositoryImpl = AnimeRepositoryImpl(seasonsApi, mapper)
            val result = repositoryImpl.getOngoingSeasonAnime()
            assertTrue(result.isFailure)
        }

    @Test
    fun `Given API call throws exception, When requesting details, Then failure result is returned`() =
        runTest {
            val exception = Exception()
            coEvery { seasonsApi.getSeasonNow() } throws exception

            repositoryImpl = AnimeRepositoryImpl(seasonsApi, mapper)
            val result = repositoryImpl.getOngoingSeasonAnime()
            assertEquals(Result.failure<List<AnimeModel>>(exception), result)
        }
}
