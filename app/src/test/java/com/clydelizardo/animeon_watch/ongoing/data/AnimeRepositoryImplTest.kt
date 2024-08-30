@file:OptIn(ExperimentalCoroutinesApi::class)

package com.clydelizardo.animeon_watch.ongoing.data

import com.clydelizardo.animeon_watch.MainCoroutineRule
import com.clydelizardo.domain.AnimeModel
import com.clydelizardo.domain.PagedListModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.openapitools.network.apis.SeasonsApi
import org.openapitools.network.models.Anime
import org.openapitools.network.models.AnimeSearch
import org.openapitools.network.models.PaginationPlusPagination
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
            val mockPagination = mockk<PaginationPlusPagination> {
                every { hasNextPage } returns true
            }
            val successResponseBody = mockk<AnimeSearch> {
                every { data } returns listOf(mockAnime)
                every { pagination } returns mockPagination
            }
            val mockAnimeModel = mockk<AnimeModel>()
            coEvery {
                seasonsApi.getSeasonNow(
                    page = eq(1),
                    sfw = eq(true)
                )
            } returns Response.success(successResponseBody)
            coEvery { mapper.map(mockAnime) } returns mockAnimeModel

            repositoryImpl = AnimeRepositoryImpl(seasonsApi, mapper)
            val result = repositoryImpl.getOngoingSeasonAnime(1)
            assertEquals(
                Result.success(
                    PagedListModel(
                        pageNumber = 1,
                        hasNext = true,
                        content = listOf(mockAnimeModel)
                    )
                ), result
            )
        }

    @Test
    fun `Given API is unavailable, When requesting details, Then failure result is returned`() =
        runTest {
            val failureResponse = mockk<Response<AnimeSearch>> {
                every { isSuccessful } returns false
            }
            coEvery {
                seasonsApi.getSeasonNow(
                    page = eq(1),
                    sfw = eq(true)
                )
            } returns failureResponse

            repositoryImpl = AnimeRepositoryImpl(seasonsApi, mapper)
            val result = repositoryImpl.getOngoingSeasonAnime(1)
            assertTrue(result.isFailure)
        }

    @Test
    fun `Given API call throws exception, When requesting details, Then failure result is returned`() =
        runTest {
            val exception = Exception()
            coEvery { seasonsApi.getSeasonNow(page = eq(1), sfw = eq(true)) } throws exception

            repositoryImpl = AnimeRepositoryImpl(seasonsApi, mapper)
            val result = repositoryImpl.getOngoingSeasonAnime(1)
            assertEquals(Result.failure<List<AnimeModel>>(exception), result)
        }
}