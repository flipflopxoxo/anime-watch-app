package com.clydelizardo.animeon_watch.di

import com.clydelizardo.animeon_watch.data.AnimeRepositoryImpl
import com.clydelizardo.animeon_watch.ongoing.domain.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AnimeModule {
    @Binds
    abstract fun animeRepository(animeRepositoryImpl: AnimeRepositoryImpl): AnimeRepository
}