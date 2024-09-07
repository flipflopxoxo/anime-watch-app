package com.clydelizardo.animeonWatch.di

import com.clydelizardo.animeonWatch.domain.ongoing.GetOngoingAnimeUseCase
import com.clydelizardo.animeonWatch.domain.ongoing.GetOngoingAnimeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class OngoingAnimeModule {
    @Binds
    abstract fun getOngoingAnimeUseCase(getOngoingAnimeUseCaseImpl: GetOngoingAnimeUseCaseImpl): GetOngoingAnimeUseCase
}
