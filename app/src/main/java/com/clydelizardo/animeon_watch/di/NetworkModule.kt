package com.clydelizardo.animeon_watch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.openapitools.network.apis.SeasonsApi
import org.openapitools.network.infrastructure.ApiClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun apiClient(): ApiClient {
        return ApiClient()
    }

    @Provides
    fun seasonsApi(apiClient: ApiClient): SeasonsApi {
        return apiClient.createService(SeasonsApi::class.java)
    }
}