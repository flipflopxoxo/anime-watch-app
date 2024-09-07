package com.clydelizardo.animeonWatch.ongoing.domain

import com.clydelizardo.animeonWatch.MainCoroutineRule
import com.clydelizardo.animeonWatch.domain.ongoing.AnimeRepository
import com.clydelizardo.animeonWatch.domain.ongoing.GetOngoingAnimeUseCaseImpl
import com.clydelizardo.models.AnimeModel
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class GetOngoingAnimeUseCaseImplTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var getOngoingAnimeUseCaseImpl: GetOngoingAnimeUseCaseImpl

    @MockK
    lateinit var mockRepository: AnimeRepository

    @Test
    fun `Given anime id and repository available, When requesting anime details, Then successful result`() =
        runTest {
            val successValue = mockk<List<AnimeModel>>()
            coEvery { mockRepository.getOngoingSeasonAnime() } returns Result.success(successValue)

            getOngoingAnimeUseCaseImpl = GetOngoingAnimeUseCaseImpl(mockRepository)

            val result = getOngoingAnimeUseCaseImpl.invoke()
            assertEquals(Result.success(successValue), result)
        }

    @Test
    fun `Given anime id and repository unavailable, When requesting anime details, Then failure result`() =
        runTest {
            val failureException = mockk<Exception>()
            coEvery { mockRepository.getOngoingSeasonAnime() } returns Result.failure(failureException)

            getOngoingAnimeUseCaseImpl = GetOngoingAnimeUseCaseImpl(mockRepository)

            val result = getOngoingAnimeUseCaseImpl.invoke()
            assertEquals(Result.failure<List<AnimeModel>>(failureException), result)
        }
}
