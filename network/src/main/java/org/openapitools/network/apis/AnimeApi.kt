package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.GetAnimeFullById200Response

interface AnimeApi {


    /**
     * 
     * 
     * Responses:
     *  - 200: Returns complete anime resource data
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetAnimeFullById200Response]
     */
    @GET("anime/{id}/full")
    suspend fun getAnimeFullById(@Path("id") id: Int): Response<GetAnimeFullById200Response>

}
