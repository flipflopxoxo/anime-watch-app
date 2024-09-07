package com.clydelizardo.animeonWatch.presentation.ongoing

import androidx.lifecycle.viewModelScope
import com.clydelizardo.animeonWatch.domain.ongoing.GetOngoingAnimeUseCase
import com.clydelizardo.animeonWatch.presentation.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OngoingAnimeListViewModel @Inject constructor(
    private val getOngoingAnimeUseCase: GetOngoingAnimeUseCase,
) : BaseViewModel<OngoingAnimeListViewAction>() {
    private val _state = MutableStateFlow(OngoingAnimeViewState(isLoading = false))
    val state = _state.asStateFlow()

    override fun handleAction(action: OngoingAnimeListViewAction): Boolean {
        return when (action) {
            OngoingAnimeListViewAction.LoadOngoingAnimeList -> {
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
                true
            }
        }
    }
}
