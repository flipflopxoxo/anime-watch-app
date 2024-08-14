package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.CharacterAnime
import org.openapitools.network.models.CharacterManga
import org.openapitools.network.models.CharacterPictures
import org.openapitools.network.models.CharacterVoiceActors
import org.openapitools.network.models.CharactersSearch
import org.openapitools.network.models.CharactersSearchQueryOrderby
import org.openapitools.network.models.GetCharacterById200Response
import org.openapitools.network.models.GetCharacterFullById200Response
import org.openapitools.network.models.SearchQuerySort

interface CharactersApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns anime that character is in
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [CharacterAnime]
     */
    @GET("characters/{id}/anime")
    suspend fun getCharacterAnime(@Path("id") id: Int): Response<CharacterAnime>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns character resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetCharacterById200Response]
     */
    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<GetCharacterById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns complete character resource data
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetCharacterFullById200Response]
     */
    @GET("characters/{id}/full")
    suspend fun getCharacterFullById(@Path("id") id: Int): Response<GetCharacterFullById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns manga that character is in
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [CharacterManga]
     */
    @GET("characters/{id}/manga")
    suspend fun getCharacterManga(@Path("id") id: Int): Response<CharacterManga>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns pictures related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [CharacterPictures]
     */
    @GET("characters/{id}/pictures")
    suspend fun getCharacterPictures(@Path("id") id: Int): Response<CharacterPictures>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns the character's voice actors
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [CharacterVoiceActors]
     */
    @GET("characters/{id}/voices")
    suspend fun getCharacterVoiceActors(@Path("id") id: Int): Response<CharacterVoiceActors>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns search results for characters
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @return [CharactersSearch]
     */
    @GET("characters")
    suspend fun getCharactersSearch(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("order_by") orderBy: CharactersSearchQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null): Response<CharactersSearch>

}
