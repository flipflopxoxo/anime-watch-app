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
 * Genre Resource
 *
 * @param malId MyAnimeList ID
 * @param name Genre Name
 * @param url MyAnimeList URL
 * @param count Genre's entry count
 */


data class Genre (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* Genre Name */
    @SerializedName("name")
    val name: kotlin.String? = null,

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    /* Genre's entry count */
    @SerializedName("count")
    val count: kotlin.Int? = null

)

