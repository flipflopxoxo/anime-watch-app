package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.GetAnimeById200Response
import org.openapitools.network.models.GetCharacterById200Response
import org.openapitools.network.models.GetMangaById200Response
import org.openapitools.network.models.GetPersonById200Response
import org.openapitools.network.models.GetRandomUsers200Response

interface RandomApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a random anime resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [GetAnimeById200Response]
     */
    @GET("random/anime")
    suspend fun getRandomAnime(): Response<GetAnimeById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a random character resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [GetCharacterById200Response]
     */
    @GET("random/characters")
    suspend fun getRandomCharacters(): Response<GetCharacterById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a random manga resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [GetMangaById200Response]
     */
    @GET("random/manga")
    suspend fun getRandomManga(): Response<GetMangaById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a random person resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [GetPersonById200Response]
     */
    @GET("random/people")
    suspend fun getRandomPeople(): Response<GetPersonById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a random user profile resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @return [GetRandomUsers200Response]
     */
    @GET("random/users")
    suspend fun getRandomUsers(): Response<GetRandomUsers200Response>

}
