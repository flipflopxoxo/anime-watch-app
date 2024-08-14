package org.openapitools.network.apis

import retrofit2.http.*
import retrofit2.Response

import org.openapitools.network.models.GenreQueryFilter
import org.openapitools.network.models.Genres

interface GenresApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: Returns entry genres, explicit_genres, themes and demographics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param filter  (optional)
     * @return [Genres]
     */
    @GET("genres/anime")
    suspend fun getAnimeGenres(@Query("filter") filter: GenreQueryFilter? = null): Response<Genres>

    /**
     * 
     * 
     * Responses:
     *  - 200: Returns entry genres, explicit_genres, themes and demographics
     *  - 400: Error: Bad request. When required parameters were not supplied.
     *
     * @param filter  (optional)
     * @return [Genres]
     */
    @GET("genres/manga")
    suspend fun getMangaGenres(@Query("filter") filter: GenreQueryFilter? = null): Response<Genres>

}
