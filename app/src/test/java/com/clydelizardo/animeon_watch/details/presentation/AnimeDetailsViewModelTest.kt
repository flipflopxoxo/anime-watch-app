package com.clydelizardo.animeon_watch.details.presentation

import com.clydelizardo.animeon_watch.MainCoroutineRule
import com.clydelizardo.animeon_watch.details.domain.GetAnimeDetailsUseCase
import io.mockk.coEvery
import io.mockk.coJustAwait
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class AnimeDetailsViewModelTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: AnimeDetailsViewModel

    @MockK
    lateinit var mockUseCase: GetAnimeDetailsUseCase

    @Test
    fun `given view model is created, then state is loading`() = runTest {
        coJustAwait { mockUseCase.invoke(any()) }
        viewModel = AnimeDetailsViewModel(mockUseCase)

        Assert.assertEquals(AnimeDetailsViewStateModel(isLoading = true), viewModel.state.first())
    }
}