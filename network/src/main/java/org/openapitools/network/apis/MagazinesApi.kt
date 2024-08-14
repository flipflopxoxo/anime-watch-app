package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.Magazines
import org.openapitools.network.models.MagazinesQueryOrderby
import org.openapitools.network.models.SearchQuerySort

interface MagazinesApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns magazines collection
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @return [Magazines]
     */
    @GET("magazines")
    suspend fun getMagazines(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("order_by") orderBy: MagazinesQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null): Response<Magazines>

}
