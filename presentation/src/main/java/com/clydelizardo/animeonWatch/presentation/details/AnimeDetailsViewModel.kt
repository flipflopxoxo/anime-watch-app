package com.clydelizardo.animeonWatch.presentation.details

import androidx.lifecycle.viewModelScope
import com.clydelizardo.animeonWatch.domain.details.GetAnimeDetailsUseCase
import com.clydelizardo.animeonWatch.presentation.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    val getAnimeDetailsUseCase: GetAnimeDetailsUseCase,
) : BaseViewModel<AnimeDetailsViewAction>() {
    private val _state = MutableStateFlow(AnimeDetailsViewStateModel())
    val state = _state.asStateFlow()

    override fun handleAction(action: AnimeDetailsViewAction): Boolean {
        return when (action) {
            is AnimeDetailsViewAction.LoadAnimeDetails -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(isLoading = true)
                    }
                    val result = getAnimeDetailsUseCase(action.animeId)
                    _state.update {
                        if (result.isSuccess) {
                            it.copy(isLoading = false, animeDetails = result.getOrThrow())
                        } else {
                            it.copy(isLoading = false, errorMessage = "Unable to get details")
                        }
                    }
                }
                true
            }
        }
    }
}
