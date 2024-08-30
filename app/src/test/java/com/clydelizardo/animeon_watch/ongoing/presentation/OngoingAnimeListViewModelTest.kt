@file:OptIn(ExperimentalCoroutinesApi::class)

package com.clydelizardo.animeon_watch.ongoing.presentation

import com.clydelizardo.animeon_watch.MainCoroutineRule
import com.clydelizardo.animeon_watch.ongoing.domain.GetOngoingAnimeUseCase
import com.clydelizardo.domain.AnimeModel
import com.clydelizardo.domain.PagedListModel
import io.mockk.coEvery
import io.mockk.coJustAwait
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class OngoingAnimeListViewModelTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: OngoingAnimeListViewModel

    @MockK
    lateinit var mockUseCase: GetOngoingAnimeUseCase

    @Test
    fun `given view model is created, then state is loading`() = runTest {
        coJustAwait { mockUseCase.invoke() }

        viewModel = OngoingAnimeListViewModel(mockUseCase)

        Assert.assertEquals(OngoingAnimeViewState(isLoading = true), viewModel.state.first())
    }

    @Test
    fun `given view model is created and use case returns success, then state is populated`() = runTest {
        val list = mockk<List<AnimeModel>>()
        val value = mockk<PagedListModel<AnimeModel>> {
            every { content } returns list
            every { hasNext } returns true
        }
        coEvery { mockUseCase.invoke() } returns Result.success(value)

        viewModel = OngoingAnimeListViewModel(mockUseCase)

        Assert.assertEquals(
            OngoingAnimeViewState(
                isLoading = false,
                animeList = list,
                pagesLoaded = 1
            ), viewModel.state.value
        )
    }

    @Test
    fun `given view model is created and use case returns failure, then state has error`() = runTest {
        coEvery { mockUseCase.invoke() } returns Result.failure(mockk())

        viewModel = OngoingAnimeListViewModel(mockUseCase)

        Assert.assertEquals(OngoingAnimeViewState(isLoading = false, errorMessage = "Unable to load list"), viewModel.state.first())
    }
}