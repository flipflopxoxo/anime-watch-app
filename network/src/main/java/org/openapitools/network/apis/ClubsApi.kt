package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.ClubRelations
import org.openapitools.network.models.ClubSearchQueryCategory
import org.openapitools.network.models.ClubSearchQueryOrderby
import org.openapitools.network.models.ClubSearchQueryType
import org.openapitools.network.models.ClubStaff
import org.openapitools.network.models.ClubsSearch
import org.openapitools.network.models.GetClubMembers200Response
import org.openapitools.network.models.GetClubsById200Response
import org.openapitools.network.models.SearchQuerySort

interface ClubsApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Club Members Resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @param page  (optional)
     * @return [GetClubMembers200Response]
     */
    @GET("clubs/{id}/members")
    suspend fun getClubMembers(@Path("id") id: Int, @Query("page") page: Int? = null): Response<GetClubMembers200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Club Relations
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [ClubRelations]
     */
    @GET("clubs/{id}/relations")
    suspend fun getClubRelations(@Path("id") id: Int): Response<ClubRelations>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Club Staff
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [ClubStaff]
     */
    @GET("clubs/{id}/staff")
    suspend fun getClubStaff(@Path("id") id: Int): Response<ClubStaff>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns Club Resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetClubsById200Response]
     */
    @GET("clubs/{id}")
    suspend fun getClubsById(@Path("id") id: Int): Response<GetClubsById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns search results for clubs
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param type  (optional)
     * @param category  (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @return [ClubsSearch]
     */
    @GET("clubs")
    suspend fun getClubsSearch(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("type") type: ClubSearchQueryType? = null, @Query("category") category: ClubSearchQueryCategory? = null, @Query("order_by") orderBy: ClubSearchQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null): Response<ClubsSearch>

}
