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
 * Magazine Resource
 *
 * @param malId MyAnimeList ID
 * @param name Magazine Name
 * @param url MyAnimeList URL
 * @param count Magazine's manga count
 */


data class Magazine (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* Magazine Name */
    @SerializedName("name")
    val name: kotlin.String? = null,

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    /* Magazine's manga count */
    @SerializedName("count")
    val count: kotlin.Int? = null

)

