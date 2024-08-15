package com.clydelizardo.animeon_watch.di

import com.clydelizardo.animeon_watch.details.data.AnimeDetailsRepositoryImpl
import com.clydelizardo.animeon_watch.details.domain.AnimeDetailsRepository
import com.clydelizardo.animeon_watch.ongoing.data.AnimeRepositoryImpl
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

    @Binds
    abstract fun animeDetailsRepository(animeDetailsRepositoryImpl: AnimeDetailsRepositoryImpl): AnimeDetailsRepository
}