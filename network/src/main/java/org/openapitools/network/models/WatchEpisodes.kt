/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.network.models

import com.google.gson.annotations.SerializedName

/**
 * Watch Episodes
 *
 * @param pagination 
 * @param `data` 
 */


data class WatchEpisodes (

    @SerializedName("pagination")
    val pagination: PaginationPagination? = null,

    @SerializedName("data")
    val `data`: kotlin.collections.List<WatchEpisodesAllOfData>? = null

)

