package com.clydelizardo.animeonWatch.presentation.details

import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCase
import com.clydelizardo.common.MainCoroutineRule
import com.clydelizardo.models.AnimeDetailsModel
import io.mockk.coEvery
import io.mockk.coJustAwait
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AnimeDetailsViewModelTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule(dispatcher = UnconfinedTestDispatcher())

    lateinit var viewModel: AnimeDetailsViewModel

    @MockK
    lateinit var mockUseCase: GetAnimeDetailsUseCase

    @Test
    fun `given view model is created, then state is loading`() =
        runTest {
            coJustAwait { mockUseCase.invoke(any()) }

            viewModel = AnimeDetailsViewModel(mockUseCase)
            viewModel.handleAction(AnimeDetailsViewAction.LoadAnimeDetails(animeId = 1))

            assertEquals(
                AnimeDetailsViewStateModel(isLoading = true),
                viewModel.state.first()
            )
        }

    @Test
    fun `given view model is created and use case returns success, then state is populated`() =
        runTest {
            val value = mockk<AnimeDetailsModel>()
            coEvery { mockUseCase.invoke(any()) } returns Result.success(value)

            viewModel = AnimeDetailsViewModel(mockUseCase)
            viewModel.handleAction(AnimeDetailsViewAction.LoadAnimeDetails(animeId = 1))

            assertEquals(
                AnimeDetailsViewStateModel(animeDetails = value),
                viewModel.state.first()
            )
        }

    @Test
    fun `given view model is created and use case returns failure, then state has error`() =
        runTest {
            coEvery { mockUseCase.invoke(any()) } returns Result.failure(mockk())

            viewModel = AnimeDetailsViewModel(mockUseCase)
            viewModel.handleAction(AnimeDetailsViewAction.LoadAnimeDetails(animeId = 1))

            assertEquals(
                AnimeDetailsViewStateModel(errorMessage = "Unable to get details"),
                viewModel.state.first()
            )
        }
}