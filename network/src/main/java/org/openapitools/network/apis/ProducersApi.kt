package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.ExternalLinks
import org.openapitools.network.models.GetProducerById200Response
import org.openapitools.network.models.GetProducerFullById200Response
import org.openapitools.network.models.Producers
import org.openapitools.network.models.ProducersQueryOrderby
import org.openapitools.network.models.SearchQuerySort

interface ProducersApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns producer resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetProducerById200Response]
     */
    @GET("producers/{id}")
    suspend fun getProducerById(@Path("id") id: Int): Response<GetProducerById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns producer's external links
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [ExternalLinks]
     */
    @GET("producers/{id}/external")
    suspend fun getProducerExternal(@Path("id") id: Int): Response<ExternalLinks>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns producer resource
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param id 
     * @return [GetProducerFullById200Response]
     */
    @GET("producers/{id}/full")
    suspend fun getProducerFullById(@Path("id") id: Int): Response<GetProducerFullById200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns producers collection
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param page  (optional)
     * @param limit  (optional)
     * @param q  (optional)
     * @param orderBy  (optional)
     * @param sort  (optional)
     * @param letter Return entries starting with the given letter (optional)
     * @return [Producers]
     */
    @GET("producers")
    suspend fun getProducers(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null, @Query("q") q: String? = null, @Query("order_by") orderBy: ProducersQueryOrderby? = null, @Query("sort") sort: SearchQuerySort? = null, @Query("letter") letter: String? = null): Response<Producers>

}
