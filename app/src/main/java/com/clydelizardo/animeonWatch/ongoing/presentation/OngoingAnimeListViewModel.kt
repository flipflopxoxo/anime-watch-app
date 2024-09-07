package com.clydelizardo.animeonWatch.ongoing.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clydelizardo.animeonWatch.ongoing.domain.GetOngoingAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OngoingAnimeListViewModel
    @Inject
    constructor(
        private val getOngoingAnimeUseCase: GetOngoingAnimeUseCase,
    ) : ViewModel() {
        private val _state = MutableStateFlow(OngoingAnimeViewState(isLoading = false))
        val state = _state.asStateFlow()

        init {
            viewModelScope.launch {
                _state.update {
                    it.copy(isLoading = true)
                }
                val result = getOngoingAnimeUseCase.invoke()
                _state.update {
                    if (result.isSuccess) {
                        it.copy(isLoading = false, animeList = result.getOrNull().orEmpty())
                    } else {
                        it.copy(isLoading = false, errorMessage = "Unable to load list")
                    }
                }
            }
        }
    }
