package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.GetPersonById200Response
import org.openapitools.network.models.GetPersonFullById200Response
import org.openapitools.network.models.PeopleSearch
import org.openapitools.network.models.PeopleSearchQueryOrderby
import org.openapitools.network.models.PersonAnime
import org.openapitools.network.models.PersonManga
import org.openapitools.network.models.PersonPictures
import org.openapitools.network.models.PersonVoiceActingRoles
import org.openapitools.network.models.SearchQuerySort

interface PeopleApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns search results for people
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @return [PeopleSearch]
     */
    @GET("people")
    suspend fun getPeopleSearch(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("order_by") orderBy: PeopleSearchQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null): Response<PeopleSearch>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns person's anime staff positions
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [PersonAnime]
     */
    @GET("people/{id}/anime")
    suspend fun getPersonAnime(@Path("id") id: Int): Response<PersonAnime>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns pictures related to the entry
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetPersonById200Response]
     */
    @GET("people/{id}")
    suspend fun getPersonById(@Path("id") id: Int): Response<GetPersonById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns complete character resource data
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetPersonFullById200Response]
     */
    @GET("people/{id}/full")
    suspend fun getPersonFullById(@Path("id") id: Int): Response<GetPersonFullById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns person's published manga works
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [PersonManga]
     */
    @GET("people/{id}/manga")
    suspend fun getPersonManga(@Path("id") id: Int): Response<PersonManga>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns a list of pictures of the person
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [PersonPictures]
     */
    @GET("people/{id}/pictures")
    suspend fun getPersonPictures(@Path("id") id: Int): Response<PersonPictures>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns person's voice acting roles
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [PersonVoiceActingRoles]
     */
    @GET("people/{id}/voices")
    suspend fun getPersonVoices(@Path("id") id: Int): Response<PersonVoiceActingRoles>

}
